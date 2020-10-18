package com.example.connect3game;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;

import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    boolean redTurn = true;
    int[] gameState = {2, 2, 2, 2, 2, 2, 2, 2, 2};
    boolean gameIsActive = true;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    public void choose(View view){
        ImageView counter = (ImageView) view;
        Button playAgain = (Button) findViewById(R.id.button);
        int tappedCounter = Integer.parseInt(counter.getTag().toString());
        if(gameState[tappedCounter]==2 && gameIsActive) {
            counter.setTranslationY(-1500);
            if (redTurn) {
                counter.setImageResource(R.drawable.red);
                gameState[tappedCounter] = 0;
                redTurn = false;
            } else {
                counter.setImageResource(R.drawable.yellow);
                gameState[tappedCounter] = 1;
                redTurn = true;
            }
            counter.animate().translationYBy(1500).rotation(360).setDuration(500);

            if ((gameState[0] == 0 && gameState[1] == 0 && gameState[2] == 0) ||
                    (gameState[3] == 0 && gameState[4] == 0 && gameState[5] == 0) ||
                    (gameState[6] == 0 && gameState[7] == 0 && gameState[8] == 0) ||
                    (gameState[0] == 0 && gameState[3] == 0 && gameState[6] == 0) ||
                    (gameState[1] == 0 && gameState[4] == 0 && gameState[7] == 0) ||
                    (gameState[2] == 0 && gameState[5] == 0 && gameState[8] == 0) ||
                    (gameState[0] == 0 && gameState[4] == 0 && gameState[8] == 0) ||
                    (gameState[2] == 0 && gameState[4] == 0 && gameState[6] == 0)
            ) {
                Toast.makeText(this, "Red won!!!", Toast.LENGTH_LONG).show();
                gameIsActive = false;
                playAgain.setVisibility(View.VISIBLE);


            } else if ((gameState[0] == 1 && gameState[1] == 1 && gameState[2] == 1) ||
                    (gameState[3] == 1 && gameState[4] == 1 && gameState[5] == 1) ||
                    (gameState[6] == 1 && gameState[7] == 1 && gameState[8] == 1) ||
                    (gameState[0] == 1 && gameState[3] == 1 && gameState[6] == 1) ||
                    (gameState[1] == 1 && gameState[4] == 1 && gameState[7] == 1) ||
                    (gameState[2] == 1 && gameState[5] == 1 && gameState[8] == 1) ||
                    (gameState[0] == 1 && gameState[4] == 1 && gameState[8] == 1) ||
                    (gameState[2] == 1 && gameState[4] == 1 && gameState[6] == 1)
            ) {
                Toast.makeText(this, "Yellow won!!!", Toast.LENGTH_LONG).show();
                gameIsActive = false;
                playAgain.setVisibility(View.VISIBLE);

            }
            boolean noOneWon = true;
            for(int i = 0 ; i  < 9 ; i ++){
                if(gameState[i] == 2){
                    noOneWon = false;
                    break;
                }
            }

           if(noOneWon)
           {
               playAgain.setVisibility(View.VISIBLE);
               Toast.makeText(this, "No one won!", Toast.LENGTH_SHORT).show();
           }
        }
    }

    public void playAgain(View view){

        androidx.gridlayout.widget.GridLayout gridLayout = findViewById(R.id.gridLayout);
        Button playAgain = findViewById(R.id.button);
        playAgain.setVisibility(View.INVISIBLE);

        for(int i=0 ;  i < gridLayout.getChildCount() ; ++i){
            ImageView counter = (ImageView) gridLayout.getChildAt(i);
            counter.setImageDrawable(null);
        }

        for(int i=0 ; i < gameState.length ; ++i){
            gameState[i] = 2;
        }

        gameIsActive = true;
        redTurn = true;


    }


}