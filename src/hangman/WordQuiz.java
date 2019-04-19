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
     * @throws IOException IOException
     * TODO: Reveal first letter of quizword?
     * TODO: Close consoleReader in a better manner
     * TODO: Maybe convert guessedLetters into Set
     * TODO: Outsource some if statements into methods
     * TODO: A a hangman art
     */
    public void playGame() throws IOException {

        char guessedChar;
        boolean gameEnd = false;
        int guessedLetterIndex = 0;

        fillGuessedWOrd();

        System.out.println("~~~~~~~~~~GAME START~~~~~~~~~~");
        System.out.println();
        System.out.printf("The length of the word is: %d%n", quizword.length());
        System.out.println();

        while (!gameEnd){
            printGameInfo();

            guessedChar = this.consoleReader.readNextChar();
            guessedLetters[guessedLetterIndex] = guessedChar;

            if (compareInput(guessedChar) == 0) {
                this.remainingAttemps--;
            }
            guessedLetterIndex++;

            if (!Arrays.toString(guessedWord).contains("_")){
                System.out.printf("CONGRATULATIONS! YOU GUESSED THE WORD !!! %s%n", quizword);
                gameEnd = true;
            }
            else if (remainingAttemps == 0 & !gameEnd){
                System.out.println("YOU HAVE 0 ATTEMPTS LEFT. YOU LOOSE !!!");
                gameEnd = true;
            }

        }

        System.out.println();
        System.out.println("~~~~~~~~~~GAME END~~~~~~~~~~");

        consoleReader.closeReader();
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
     * TODO: uncover is juts used once because of good intent
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
            builder.append(character).append(" ");
        }
        System.out.printf("Your guesses: %s%n", builder.toString());

        // print the current status of the guessedWord
        builder = new StringBuilder();
        for (char c : guessedWord) {
            builder.append(c);
        }
        System.out.printf("Quizword: %s%n", builder.toString());

        // Spaces the output
        System.out.println();

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
