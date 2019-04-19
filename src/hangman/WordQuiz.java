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
    public WordQuiz(int wordLength, int remainingAttemps, ConsoleReader consoleReader, WordlistReader wordlistReader) throws IOException {

        this.guessedLetters = new char[remainingAttemps + wordLength];
        Arrays.fill(guessedLetters, ' ');

        this.remainingAttemps = remainingAttemps;
        this.consoleReader = consoleReader;
        this.wordlistReader = wordlistReader;
        this.quizword = wordlistReader.getRandomWordWithLengthFromList(wordLength);
        this.guessedWord = new char[wordLength];
    }

    /**
     * Starts the hangman game
     * @throws IOException IOException
     * TODO: Close consoleReader in a better manner
     * TODO: A a hangman art
     */
    public void playGame() throws IOException {

        char guessedChar;
        boolean gameEnd = false;
        int guessedLetterIndex = 0;

        fillGuessedWOrd();
        uncoverFirst();

        System.out.println("~~~~~~~~~~GAME START~~~~~~~~~~");
        System.out.println();
        System.out.printf("The length of the word is: %d%n", quizword.length());
        System.out.println();

        while (!gameEnd){
            printGameInfo();

            //Get char from input and check if its already been guessed
            guessedChar = this.consoleReader.readNextChar();
            if (!alradyGuessed(guessedChar))guessedLetters[guessedLetterIndex] = guessedChar;
            else remainingAttemps--;

            // wrong guess
            if (compareInput(guessedChar) == 0) remainingAttemps--;
            guessedLetterIndex++;

            // win
            if (!String.valueOf(guessedWord).contains("_")){
                System.out.printf("The quizzword is: %s%n", quizword);
                System.out.println("CONGRATULATIONS! YOU GUESSED THE WORD !!!");
                gameEnd = true;
            }
            // lose
            else if (remainingAttemps == 0){
                System.out.println("YOU HAVE 0 ATTEMPTS LEFT. YOU LOOSE !!!");
                gameEnd = true;
            }

        }

        // game end message
        System.out.println();
        System.out.println("~~~~~~~~~~GAME END~~~~~~~~~~");

        consoleReader.closeReader();
    }

    /**
     * Uncovers the first letter of the quizword
     */
    private void uncoverFirst(){
        guessedWord[0] = quizword.charAt(0);
    }

    /**
     * Checks whether a char has already been guessed or not
     * @param guessedChar guessed character
     * @return whether a char has already been guessed or not
     */
    private boolean alradyGuessed(char guessedChar){
        boolean alreadyGeussed = false;
        if (String.valueOf(guessedLetters).contains(String.valueOf(guessedChar))){
            alreadyGeussed = true;
        }
        return alreadyGeussed;
    }

    /**
     * Compares the input to the quizword
     * @param character character
     * @return 1=equals, 0=not equal, //-1= error
     */
    protected int compareInput(char character){
        String search = String.valueOf(character).toLowerCase();
        if (quizword.toLowerCase().contains(search)) {

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
        guessedWord[index] = character;
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
        //System.out.println(String.valueOf(guessedWord));
        builder = new StringBuilder();
        for (char c : guessedWord) {
            builder.append(c).append(" ");
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
            guessedWord[i] = '_';
        }
    }


}
