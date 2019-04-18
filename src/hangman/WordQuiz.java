package hangman;

import java.io.IOException;
import java.util.Arrays;

/**
 * WordQuiz is the main class for the hangman game
 * 17.04.2019
 * @author Daniel Marten
 */
public class WordQuiz {

    protected String quizword;
    protected char[] guessedWord;
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
    public WordQuiz(int wordLength, int remainingAttemps, ConsoleReader consoleReader, WordlistReader wordlistReader) throws NoSuchFieldException {
        this.guessedLetters = new char[remainingAttemps + wordLength];
        this.remainingAttemps = remainingAttemps;
        this.consoleReader = consoleReader;
        this.wordlistReader = wordlistReader;
        //this.quizword = wordlistReader.getWordsOfLength(wordLength);
        this.quizword = wordlistReader.getRandomWordFromList(wordLength);
        this.guessedWord = new char[wordLength];
    }

    /**
     * Starts the hangman game
     */
    public void playGame() throws IOException {

        char guessedChar;
        int counter = 0;

        fillGuessedWOrd();

        System.out.println("~~~~~~~~~~~~~GAME START~~~~~~~~~~~~~~");
        System.out.println();
        System.out.printf("The length of the word is: %d%n", quizword.length());
        System.out.println();

        while (true){
            printGameInfo();

            guessedChar = this.consoleReader.readNextChar();
            guessedLetters[counter] = guessedChar;

            if (compareInput(guessedChar) == 0) {
                this.remainingAttemps--;
            }
            counter++;

            if (!Arrays.toString(guessedWord).contains("_")){
                System.out.println("YOU GUESSED THE WORD !!!");
                break;
            }
            else if (remainingAttemps == 0){
                System.out.println("YOU HAVE 0 ATTEMPS LEFT. YOU LOOSE !!!");
                break;
            }

        }
    }



    /**
     * Compares the input to the quizword
     * @param character character
     * @return 1=equals, 0=not equal, //-1= error
     */
    protected int compareInput(char character){
        String search = String.valueOf(character).toLowerCase();
        if (this.quizword.toLowerCase().contains(search)) {

            for (int i = 0; i < quizword.length(); i++) {
                if (quizword.toLowerCase().charAt(i) == Character.toLowerCase(character)) {
                    uncover(quizword.charAt(i), i);
                }
            }

            return 1;
        }
        else {
            return 0;
        }
    }

    /**
     * Replaces the _ at a specified index in guessedWord
     * @param character character to replace _
     * @param index index of the guessedWord
     */
    protected void uncover(char character, int index){
        this.guessedWord[index] = character;
    }

    /**
     * Prints the statuses of the game to the console
     */
    private void printGameInfo(){

        // print remainingAttempts
        System.out.printf("Remaining Attemps: %d%n", this.remainingAttemps);

        //print guessedletters
        StringBuilder builder = new StringBuilder();
        for (char character : guessedLetters){
            builder.append(character);
        }
        System.out.printf("Guessed letters: %s%n", builder.toString());

        // print the current status of the guessedWord
        builder = new StringBuilder();
        for (char c : guessedWord) {
            builder.append(c);
        }
        System.out.printf("Quizword: %s%n", builder.toString());

    }

    /**
     * Method for filling guessedWord with _
     */
    private void fillGuessedWOrd(){
        for (int i = 0; i < quizword.length(); i++){
            this.guessedWord[i] = '_';
        }
    }


}
