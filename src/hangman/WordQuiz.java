package hangman;

import java.io.IOException;
import java.util.Arrays;

/**
 * WordQuiz is the main class for the hangman game
 * 17.04.2019
 * @author Daniel Marten
 * TODO: What happens if the wordlist is empty
 * TODO: if you enter a char it will only uncover one --> can never win :(
 * TODO: uncover is never used
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
    public WordQuiz(int wordLength, int remainingAttemps, ConsoleReader consoleReader, WordlistReader wordlistReader){
        this.guessedLetters = new char[remainingAttemps];
        this.remainingAttemps = remainingAttemps;
        this.consoleReader = consoleReader;
        this.wordlistReader = wordlistReader;
        this.quizword = wordlistReader.getWordsOfLength(wordLength);
//        this.quizword = wordlistReader.getRandomWordFromList();
        this.guessedWord = new char[wordLength];
    }

    /**
     * Starts the hangman game
     */
    public void playGame() throws IOException {

        boolean gameEnd = false;
        char guessedChar;
        int counter = 0;

        fillGuessedWOrd();

        System.out.println("~~~~~~~~~~~~~GAME START~~~~~~~~~~~~~~");
        System.out.println();
        System.out.printf("The length of the word is: %d%n", quizword.length());
        System.out.println();

        while (gameEnd == false){
            printGameInfo();

            guessedChar = this.consoleReader.readNextChar();
            guessedLetters[counter] = guessedChar;

            if (compareInput(guessedChar) == 1){
                for (int i = 0; i < quizword.length(); i++){
                    if (quizword.charAt(i) == guessedChar){
                        uncover(guessedChar, i);
                    }
                }
            }

            if (!Arrays.toString(guessedWord).contains("_")){
                gameEnd = true;
                System.out.println("YOU GUESSED THE WORD !!!");
                gameEnd = true;
            }
            else if (remainingAttemps == 0){
                gameEnd = true;
                System.out.println("YOU HAVE TO ATTEMPS LEFT. YOU LOOSE !!!");
            }

            this.remainingAttemps--;
            counter++;
        }


    }



    /**
     * Compares the input to the quizword
     * @param character character
     * @return 1=equals, 0=not equal, //-1= error
     */
    protected int compareInput(char character){
        try{
            String search = String.valueOf(character).toLowerCase();
            if (this.quizword.toLowerCase().contains(search))
                return 1;
            else {
                return 0;
            }
        }
        catch (Exception e){
            return -1;
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
