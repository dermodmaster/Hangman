package hangman;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * Class to easily read from a BufferedReader
 * 17.04.2019
 * @author Daniel Marten, Maximilian Frömelt, Ruben Klinksiek
 */
public class ConsoleReader {

    private BufferedReader reader;

    /**
     * Constructor for Console Reader
     * @param br BufferedReader to read from
     */
    public ConsoleReader(BufferedReader br){
        this.reader = br;
    }

    /**
     * Reads and then returns the next char from user input
     * @return next char
     */
    public char readNextChar() throws IOException {

        String character_string = this.reader.readLine();

        if (character_string.isEmpty()) {
            throw new IOException("Empty input!");
        }

        if (character_string.length() > 1) {
            System.out.println(" More than 1 char as input detected: taking first char!");
        }

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
