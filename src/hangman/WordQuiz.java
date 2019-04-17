package hangman;

/**
 * WordQuiz is the main class for the hangman game
 * 17.04.2019
 * @author Daniel Marten
 */
public class WordQuiz {

    protected String quizword;
    protected char[] guessedLetters;
    protected int remainingAttemps;
    protected ConsoleReader inputReader;
    protected WordlistReader wordlistReader;

    /**
     * Constructor for WordQuiz
     * @param wordLength length of the word to guess
     * @param remainingAttemps remainig Attemps
     * @param inputReader Console Reader
     * @param wordlistReader Wordlist Reader
     */
    public WordQuiz(int wordLength, int remainingAttemps, ConsoleReader inputReader, WordlistReader wordlistReader){
        this.guessedLetters = new char[wordLength];
        this.remainingAttemps = remainingAttemps;
        this.inputReader = inputReader;
        this.wordlistReader = wordlistReader;
    }

    /**
     * Starts the hangman game
     */
    public void playGame(){
        //Start game

    }

    /**
     * Compares the input to
     * @param c character
     * @return 1=equals, 0=not equal
     */
    protected int copareInput(char character){

        return 0;
    }

    /**
     * Uncovers the letters of the word
     * @param character character to uncovver
     * @param index index of the word
     * TODO: not sure if you ha
     */
    protected void uncover(char character, int index){


    }

    /**
     * Prints the statuses of the game to the console
     */
    private void printGameInfo(){

    }


}
