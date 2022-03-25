package com.example.hangmanproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class GameOver extends AppCompatActivity{
    private String finalScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Open the Main Menu on start
        setContentView(R.layout.gameover);

        //Show current game score
        finalScore = "Score: " + Game.getScore();
        ((TextView) findViewById(R.id.currentScore)).setText(finalScore);

        //TODO Check value of high score and if less than current game score, replace it

    }

    //Open Main Menu on Button press
    public void openMenu(View v){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

    }
}
