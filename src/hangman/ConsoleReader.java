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
     * @param br BufferedReader (with InputStreamReader, System.in)
     */
    public ConsoleReader(BufferedReader br){
        this.reader = br;
    }

    /**
     * Reads and then returns the next char from user input
     * @return next char
     * TODO: Maybe exclude numbers fom input
     */
    public char readNextChar() throws IOException {

        String character_string = "";
        char character;

        System.out.println("Take a guess: ");

        character_string = this.reader.readLine();

        if (character_string.length() > 1) System.out.println("More than 1 char as input detected: taking first char!");
        if (character_string.isEmpty()) System.out.println("Empy input!");

        character = character_string.charAt(0);
        return character;
    }

    /**
     * Function for closing the BufferedReader
     * @throws IOException There is no reader
     */
    public void closeReader() throws IOException {
        reader.close();
    }

}
