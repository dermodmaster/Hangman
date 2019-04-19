package hangman;

import java.io.IOException;
import java.util.Arrays;

import static hangman.WordQuizAsciiArt.printArt;

/**
 * WordQuiz is the main class for the hangman game
 * 17.04.2019
 * @author Daniel Marten, Maximilian Frömelt, Ruben Klinksiek
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
     * @param remainingAttempts remainig Attemps
     * @param consoleReader Console Reader
     * @param wordlistReader Wordlist Reader
     * @throws NoSuchFieldException if no word of wordLength are found
     */
    public WordQuiz(int wordLength, int remainingAttempts, ConsoleReader consoleReader, WordlistReader wordlistReader) throws NoSuchFieldException {
        this.guessedLetters = new char[remainingAttempts + wordLength];
        Arrays.fill(guessedLetters, ' ');

        this.remainingAttemps = remainingAttempts;
        this.consoleReader = consoleReader;
        this.wordlistReader = wordlistReader;
        this.quizword = wordlistReader.getRandomWordWithLengthFromList(wordLength);
        this.guessedWord = new char[wordLength];
    }

    /**
     * Starts the hangman game
     * TODO: A a hangman ASCII art
     */
    public void playGame() {

        char guessedChar;
        int guessedLetterIndex = 0;
        fillGuessedWOrd();
        guessedWord[0] = quizword.charAt(0); // reveal first letter

        System.out.printf("~~~~~~~~~~GAME START~~~~~~~~~~%nThe length of the word is: %d%n%n", quizword.length());


        while (true){
            printGameInfo();

            // Get char from input
            System.out.print("Take a guess: ");

            while(true) {
                try { /* try until successful, possibly implement exit after n fails */
                    guessedChar = this.consoleReader.readNextChar();
                    if (String.valueOf(guessedChar).matches("[a-zA-Z]"))
                        break;
                    else
                        System.out.println("not a valid input, try again: ");
                } catch (IOException ex) {}
            }

            System.out.println(); // Spaces the output

            // check if its already been guessed, if not, add it
            if (!alreadyGuessed(guessedChar))
                guessedLetters[guessedLetterIndex] = guessedChar;

            // wrong guess
            if (compareInput(guessedChar) == 0)
                remainingAttemps--;

            printArt(remainingAttemps);

            // win condition
            if (!String.valueOf(guessedWord).contains("_")){
                System.out.printf("The quizzword is: %s%n", quizword);
                System.out.println("CONGRATULATIONS! YOU GUESSED THE WORD !!!");
                break;
            }

            // lose condition
            else if (remainingAttemps == 0){
                System.out.println("YOU HAVE 0 ATTEMPTS LEFT. YOU LOOSE !!!");
                break;
            }

            guessedLetterIndex++;
        }


        System.out.println("\n~~~~~~~~~~GAME END~~~~~~~~~~"); // game end message
    }

    /**
     * Checks whether a char has already been guessed or not
     * @param guessedChar guessed character
     * @return whether a char has already been guessed or not
     */
    private boolean alreadyGuessed(char guessedChar){
        if (String.valueOf(guessedLetters).contains(String.valueOf(guessedChar))){
            return true;
        }
        return false;
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
