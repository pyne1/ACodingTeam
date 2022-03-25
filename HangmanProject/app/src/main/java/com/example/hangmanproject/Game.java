package com.example.hangmanproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

//These imports may not be allowed
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ImageView;


public class Game extends AppCompatActivity {
    //List of words (2D String array, index i for difficulty, index j for words in difficulty i)
    private final String[][] wordList = {
            //Words will be added later
            { "box", "glue", "blue", "bag", "car", "tire", "horn", "seat", "gas"},
            { "audi" , "windows" , "headlights" , "keyhole" , "vehicle" , "pixel" , "tesla" , "electric" , "bentley" , "buick" },
            { "toyota", "cadillac", "chevrolet", "dynamics", "police", "robbery", "traffic", "highway", "espionage", "rhythm" },
            { "bmw", "fjord", "porsche", "corolla", "radio", "ticket", "parking"},
            { "lamborghini", "mercedes"}
    };
    //String holding chosen letter
    private String chosenWrd;
    //String representing hidden/revealed characters of the chosen String
    private String hiddenWrd;
    //Current score for this game session
    private static int score;
    //User lives
    private int lives;
    //Difficulty scale (0 to 4)
    private int difficulty;


    //Saved instance of game (Prevent change on orientation)
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        // save state of your activity to outState
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        //Open the Main Menu on start
        setContentView(R.layout.activity_main);

        //"Default constructor" behaviour
        difficulty = 0;
        chosenWrd = wordList[difficulty][(int) (Math.random() * wordList[difficulty].length)];
        hiddenWrd = "";
        //Censors chosen word
        for(int i = 0; i < chosenWrd.length(); i++){
            hiddenWrd += "_";
        }
        score = 0;
        lives = 5;

        ((TextView) findViewById(R.id.hiddenWord)).setText(hiddenWrd);
        ((TextView) findViewById(R.id.livesLeft)).setText("Lives: " + lives);
    }

    public void createLevel(int difficulty){
        Button[] buttons = new Button[26];
        //Reset all buttons
        resetAllButtons(true, 255);
        chosenWrd = wordList[difficulty][(int) (Math.random() * wordList[difficulty].length)];
        hiddenWrd = "";
        //Censors chosen word
        for(int i = 0; i < chosenWrd.length(); i++){
            hiddenWrd += "_";
        }
        ((TextView) findViewById(R.id.hiddenWord)).setText(hiddenWrd);
        ((TextView) findViewById(R.id.livesLeft)).setText("Lives: " + lives);
    }

    //TODO Figure out a way to iterate through 26 buttons rather than doing so manually
    public void resetAllButtons( boolean canClick, int opacity ){

        ((TextView) findViewById(R.id.letter1)).getBackground().setAlpha(opacity);
        ((TextView) findViewById(R.id.letter1)).setClickable(canClick);

        ((TextView) findViewById(R.id.letter2)).getBackground().setAlpha(opacity);
        ((TextView) findViewById(R.id.letter2)).setClickable(canClick);

        ((TextView) findViewById(R.id.letter3)).getBackground().setAlpha(opacity);
        ((TextView) findViewById(R.id.letter3)).setClickable(canClick);

        ((TextView) findViewById(R.id.letter4)).getBackground().setAlpha(opacity);
        ((TextView) findViewById(R.id.letter4)).setClickable(canClick);

        ((TextView) findViewById(R.id.letter5)).getBackground().setAlpha(opacity);
        ((TextView) findViewById(R.id.letter5)).setClickable(canClick);

        ((TextView) findViewById(R.id.letter6)).getBackground().setAlpha(opacity);
        ((TextView) findViewById(R.id.letter6)).setClickable(canClick);

        ((TextView) findViewById(R.id.letter7)).getBackground().setAlpha(opacity);
        ((TextView) findViewById(R.id.letter7)).setClickable(canClick);

        ((TextView) findViewById(R.id.letter8)).getBackground().setAlpha(opacity);
        ((TextView) findViewById(R.id.letter8)).setClickable(canClick);

        ((TextView) findViewById(R.id.letter9)).getBackground().setAlpha(opacity);
        ((TextView) findViewById(R.id.letter9)).setClickable(canClick);

        ((TextView) findViewById(R.id.letter10)).getBackground().setAlpha(opacity);
        ((TextView) findViewById(R.id.letter10)).setClickable(canClick);

        ((TextView) findViewById(R.id.letter11)).getBackground().setAlpha(opacity);
        ((TextView) findViewById(R.id.letter11)).setClickable(canClick);

        ((TextView) findViewById(R.id.letter12)).getBackground().setAlpha(opacity);
        ((TextView) findViewById(R.id.letter12)).setClickable(canClick);

        ((TextView) findViewById(R.id.letter13)).getBackground().setAlpha(opacity);
        ((TextView) findViewById(R.id.letter13)).setClickable(canClick);

        ((TextView) findViewById(R.id.letter14)).getBackground().setAlpha(opacity);
        ((TextView) findViewById(R.id.letter14)).setClickable(canClick);

        ((TextView) findViewById(R.id.letter15)).getBackground().setAlpha(opacity);
        ((TextView) findViewById(R.id.letter15)).setClickable(canClick);

        ((TextView) findViewById(R.id.letter16)).getBackground().setAlpha(opacity);
        ((TextView) findViewById(R.id.letter16)).setClickable(canClick);

        ((TextView) findViewById(R.id.letter17)).getBackground().setAlpha(opacity);
        ((TextView) findViewById(R.id.letter17)).setClickable(canClick);

        ((TextView) findViewById(R.id.letter18)).getBackground().setAlpha(opacity);
        ((TextView) findViewById(R.id.letter18)).setClickable(canClick);

        ((TextView) findViewById(R.id.letter19)).getBackground().setAlpha(opacity);
        ((TextView) findViewById(R.id.letter19)).setClickable(canClick);

        ((TextView) findViewById(R.id.letter20)).getBackground().setAlpha(opacity);
        ((TextView) findViewById(R.id.letter20)).setClickable(canClick);

        ((TextView) findViewById(R.id.letter21)).getBackground().setAlpha(opacity);
        ((TextView) findViewById(R.id.letter21)).setClickable(canClick);

        ((TextView) findViewById(R.id.letter22)).getBackground().setAlpha(opacity);
        ((TextView) findViewById(R.id.letter22)).setClickable(canClick);

        ((TextView) findViewById(R.id.letter23)).getBackground().setAlpha(opacity);
        ((TextView) findViewById(R.id.letter23)).setClickable(canClick);

        ((TextView) findViewById(R.id.letter24)).getBackground().setAlpha(opacity);
        ((TextView) findViewById(R.id.letter24)).setClickable(canClick);

        ((TextView) findViewById(R.id.letter25)).getBackground().setAlpha(opacity);
        ((TextView) findViewById(R.id.letter25)).setClickable(canClick);

        ((TextView) findViewById(R.id.letter26)).getBackground().setAlpha(opacity);
        ((TextView) findViewById(R.id.letter26)).setClickable(canClick);
    }

    /*
    * checkLetter(String letter) Method
    * Preconditions: A letter button has been pressed
    * Postconditions:
    * Disable and fade letter button pressed
    * If letter is in chosenWord at least once, replace letters appropriately, next level if hiddenWrd = chosenWrd
    * If letter is not in chosenWord, decrement lives by one and end game if lives = 0
     */
    public void checkLetter(View v){
        //Disable button clicked
        v.getBackground().setAlpha(50);
        v.setClickable(false);
        //Get letter of button clicked and check if in chosen word
        String letter = ((Button) v).getText().toString().toLowerCase();
        if(chosenWrd.indexOf(letter) != -1){
            for(int i = 0; i < chosenWrd.length(); i++){

                if(String.valueOf(chosenWrd.charAt(i)).equals(letter)){
                    hiddenWrd = hiddenWrd.substring(0, i) + letter + hiddenWrd.substring(i+1);
                }

            }
            //Update hiddenWrd on screen
            ((TextView) findViewById(R.id.hiddenWord)).setText(hiddenWrd);
            //Check if word is complete
            if(hiddenWrd.equals(chosenWrd)){
                //Add and show score
                score++;
                ((TextView) findViewById(R.id.scoreViewer)).setText("Score: " + score);
                //Add life if score is a multiple of 3 and lives less then 5
                if(lives < 5 && score % 3 == 0){
                    lives++;
                }
                //Increase difficulty if score is a multiple of 5
                if( score % 5 == 0){
                    if(difficulty < 5){
                        difficulty++;
                    }else{
                        difficulty = (int)(Math.random() * 5) + 0;
                    }

                }
                //Go to next level
                createLevel(difficulty);
            }
        }else{
            lives--;
            ((TextView) findViewById(R.id.livesLeft)).setText("Lives: " + lives);
            if(lives == 0){
                gameOver();
            }
        }
    }

    public static int getScore(){
        return score;
    }
    
    public void pauseGame(View v){
        changeView(true);
    }
    public void unpauseGame(View v){
        changeView(false);
    }
    public void changeView(boolean isPaused){
        //Disable visibility of everything but vertical linear layout
        if(isPaused){
            ((LinearLayout) findViewById(R.id.keyboard1)).setVisibility(View.GONE);
            ((LinearLayout) findViewById(R.id.keyboard2)).setVisibility(View.GONE);
            ((LinearLayout) findViewById(R.id.keyboard3)).setVisibility(View.GONE);

            ((TextView) findViewById(R.id.livesLeft)).setVisibility(View.GONE);
            ((TextView) findViewById(R.id.hiddenWord)).setVisibility(View.GONE);
            ((TextView) findViewById(R.id.scoreViewer)).setVisibility(View.GONE);
            ((ImageView) findViewById(R.id.carImage)).setVisibility(View.GONE);
            ((ImageView) findViewById(R.id.carImage)).setVisibility(View.GONE);
            ((Button) findViewById(R.id.pauseButton)).setVisibility(View.GONE);

            ((LinearLayout) findViewById(R.id.pausedScreen)).setVisibility(View.VISIBLE);
        }else{
            ((LinearLayout) findViewById(R.id.keyboard1)).setVisibility(View.VISIBLE);
            ((LinearLayout) findViewById(R.id.keyboard2)).setVisibility(View.VISIBLE);
            ((LinearLayout) findViewById(R.id.keyboard3)).setVisibility(View.VISIBLE);

            ((TextView) findViewById(R.id.livesLeft)).setVisibility(View.VISIBLE);
            ((TextView) findViewById(R.id.hiddenWord)).setVisibility(View.VISIBLE);
            ((TextView) findViewById(R.id.scoreViewer)).setVisibility(View.VISIBLE);
            ((ImageView) findViewById(R.id.carImage)).setVisibility(View.VISIBLE);
            ((ImageView) findViewById(R.id.carImage)).setVisibility(View.VISIBLE);
            ((Button) findViewById(R.id.pauseButton)).setVisibility(View.VISIBLE);

            ((LinearLayout) findViewById(R.id.pausedScreen)).setVisibility(View.GONE);
        }

    }
    //TODO An image of a vehicle will be built on to indicate number of lives; parts will disappear for lives lost and reappear when lives are restored

    /*
     * gameOver Method (Identical to quit):
     * Preconditions: When lives are checked after an incorrect guess, lives == 0
     * Postconditions:
     * highScore set to score if score > highScore (highScore is saved in device)
     * Change to game over screen
     */
    public void gameOver(){
        resetAllButtons(false, 50);
        Intent intent = new Intent(this, GameOver.class);
        startActivity(intent);
    }

    public void openMenu(View v){
        changeView(false);
        gameOver();

    }
}
