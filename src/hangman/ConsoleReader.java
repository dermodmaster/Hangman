package hangman;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * Klasse zum Lesen der geratenen Zeichen von der Tastatur
 * 17.04.2019
 * @author Daniel Marten
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
     * TODO: ugly code lul
     */
    public char readNextChar(){
        String character_string = "";
        char character;
        System.out.println("Take a guess: ");
        try {
            character_string = this.reader.readLine();
            if (character_string.isEmpty())throw new IOException("Bad input!");
            character = character_string.charAt(0);
            return character;
        }
        catch (IOException e){
            e.printStackTrace();
            return 'a';
        }
    }

    /**
     * Function for closing the BufferedReader
     * @throws IOException There is no reader
     * TODO: Maybe relocate br into try with recourse
     */
    public void closeReader() throws IOException {
        reader.close();
    }

}
