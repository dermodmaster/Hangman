package hangman;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * WordQuiz is the main class for the hangman game
 * 17.04.2019
 * @author Daniel Marten
 */
public class WordQuiz {

    protected String quizword;
    protected char[] guessedLetters;
    protected int remainingAttemps;
    protected ConsoleReader consoleReader;
    protected WordlistReader wordlistReader;

    /**
     * Constructor for WordQuiz
     * @param wordLength length of the word to guess
     * @param remainingAttemps remainig Attemps
     * @param consoleReader Console Reader
     * @param wordlistReader Wordlist Reader
     */
    public WordQuiz(int wordLength, int remainingAttemps, ConsoleReader consoleReader, WordlistReader wordlistReader){
        this.quizword = "";
        this.guessedLetters = new char[remainingAttemps];
        this.remainingAttemps = remainingAttemps;
        this.consoleReader = consoleReader;
        this.wordlistReader = wordlistReader;
    }

    /**
     * Starts the hangman game
     */
    public void playGame()throws IOException {
        System.out.println("~~~~~~~~~~~~~GAME START~~~~~~~~~~~~~~");
        System.out.println();
        printGameInfo();






    }

    /**
     * Compares the input to the quizword
     * @param character character
     * @return 1=equals, 0=not equal, -1= error
     */
    protected int copareInput(char character){

        return 0;
    }

    /**
     * Uncovers the letters of the word
     * @param character character to uncover
     * @param index index of the word
     * TODO: not sure if you ha
     */
    protected void uncover(char character, int index){


    }

    /**
     * Prints the statuses of the game to the console
     */
    private void printGameInfo(){

        System.out.printf("Remaining Attemps: %d%n", this.remainingAttemps);

        StringBuilder guessed = new StringBuilder();
        for (char character : guessedLetters){
            guessed.append(character);
        }
        System.out.printf("Guessed letters: %s%n", guessed);

    }


}
