package hangman;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * Klasse zum Lesen eines Zeichen von der eingabe
 * 17.04.2019
 * @author Daniel Marten, Maximilian Frömelt, Ruben Klinksiek
 */
public class ConsoleReader {

    private BufferedReader reader;

    /**
     * Constructor for Console Reader
     * @param br BufferedReader (ideally with InputStreamReader, System.in)
     */
    public ConsoleReader(BufferedReader br){
        this.reader = br;
    }

    /**
     * Reads and then returns the next char from user input
     * @return next char
     * TODO: Maybe exclude numbers fom input
     * TODO: If input is a guessed word maybe subtract the length of the input from remainingAttempts instead of just taking the first letter...
     */
    public char readNextChar() throws IOException {

        String character_string = "";

        System.out.print("Take a guess: ");

        character_string = this.reader.readLine();

        if (character_string.length() > 1) System.out.println("More than 1 char as input detected: taking first char!");
        if (character_string.isEmpty()){
            System.out.println("Empty input! If you enter nothing again you will exit.");
            System.out.print("Take a guess: ");
            if ((character_string=reader.readLine()).isEmpty() ) throw new IOException("Empty input! Now exiting...");
        }

        // Spaces the output
        System.out.println();

        return character_string.charAt(0);
    }

    /**
     * Function for closing the BufferedReader
     * @throws IOException There is no reader
     */
    public void closeReader() throws IOException {
        reader.close();
    }

}
