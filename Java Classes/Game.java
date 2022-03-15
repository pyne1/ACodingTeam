package com.example.hangmanproject;

public class Game {
    //List of words (2D String array, index i for difficulty, index j for words in difficulty i)
    private final String[][] wordList = {
            //Words will be added later
            { "", "" },
            { "" },
            { "" }
    };
    //String holding chosen letter
    private String chosenWrd;
    //String representing hidden/revealed characters of the chosen String
    private String hiddenWrd;
    //Current score for this game session
    private int score;
    //User lives
    private int lives;

    //Default constructor starts game with a random easy difficulty word (index (0, random))
    public Game() {
        chosenWrd = wordList[0][(int) (Math.random() * wordList[0].length)];
        hiddenWrd = "";
        //Censors chosen word
        for(int i = 0; i < chosenWrd.length(); i++){
            hiddenWrd += "_";
        }

        score = 0;
        lives = 5;
    }

    //Below are to be implemented

    /*
    * nextLevel Method:
    * Precondition: User has found the word
    * Postconditions:
    * score increment 1
    * chosenWord selects new word
    * hiddenWord censors according to new chosenWord
    * lives increment IF score % 3 == 0 (MAX 5 lives)
    * Difficulty array increases if score % 5 = 0 (MAX difficulty 5)
    *
     */

    /*
    * gameOver Method (Identical to quit):
    * Preconditions: When lives are checked after an incorrect guess, lives == 0
    * Postconditions:
    * highScore set to score if score > highScore (highScore is saved in device)
    * Change to game over screen
     */

    /*
    * checkLetter(String letter) Method
    * Preconditions: A letter button has been pressed
    * Postconditions:
    * Disable and fade letter button pressed
    * If letter is in chosenWord at least once, call replaceLetter(String letter)
    * If letter is not in chosenWord, decrement lives by one and end game if lives = 0
     */

    /*
    * replaceLetter(String letter)
    * Preconditions: letter is in chosenWord at least once
    * Postconditions:
     */

    //Add Pause method
    
    //An image of a vehicle will be built on to indicate number of lives; parts will disappear for lives lost and reappear when lives are restored

}
