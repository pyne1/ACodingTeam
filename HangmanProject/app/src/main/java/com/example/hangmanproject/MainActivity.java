package com.example.hangmanproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button startGame;
    private Button highScoreBtn;
    private Button instructionsBtn;
    private Button settingsBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Open the Main Menu on start
        setContentView(R.layout.mainmenu);

        //SET BUTTONS TO THEIR ONCLICK LISTENERS
        startGame = (Button) findViewById(R.id.newGame);
        startGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openGame();
            }
        });

        highScoreBtn = (Button) findViewById(R.id.highScore);
        highScoreBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openHighScore();
            }
        });

        instructionsBtn = (Button) findViewById(R.id.howToPlay);
        instructionsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openHowTo();
            }
        });

        settingsBtn = (Button) findViewById(R.id.settingsPg);
        settingsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSettings();
            }
        });

    }

    //Open NEW Game on Button press
    public void openGame(){
        Intent intent = new Intent(this, Game.class);
        startActivity(intent);
    }
    //Open High Scores on Button press
    public void openHighScore(){
        Intent intent = new Intent(this, HighScores.class);
        startActivity(intent);
    }
    //Open High Scores on Button press
    public void openHowTo(){
        Intent intent = new Intent(this, HighScores.class);
        startActivity(intent);
    }
    //Open Settings on Button press
    public void openSettings(){
        Intent intent = new Intent(this, Settings.class);
        startActivity(intent);
    }
}