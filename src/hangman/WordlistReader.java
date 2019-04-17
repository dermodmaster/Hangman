package hangman;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

/**
 * Klasse zum lesen einer Liste mit zu erratenden Wörtern aus einer Textdatei
 * 17.04.2019
 * @author Daniel Marten
 * TODO: relocate wordlist to resource folder
 */
public class WordlistReader {

    private List<String> wordlist;
    private String file;

    /**
     * Constructor for WordlistReader
     * @param file zu filepath for the file with words in it
     */
    public WordlistReader(String file) throws IOException {
        this.wordlist = new ArrayList<>();
        this.file = file;
        readListFromFile();
    }

    /**
     * Reads a specified file into a List
     * @return true if done correctly, else false
     */
    protected boolean readListFromFile() throws IOException {
        Path filePath = new File(file).toPath();
        wordlist = Files.readAllLines(filePath);

        if (wordlist.isEmpty()) throw new IOException("The file couldn't be read or is empty!");

        return true;
    }

    /**
     * Returns all words of the specified length as a List
     * @param length desired length of the words
     * @return words of desired length as List
     */
    public List<String> getWordsOfLength(int length){

        List<String> result = new ArrayList<>();

        for (String word : wordlist){
            if (word.length()==length){
                result.add(word);
            }
        }
        return result;
    }

    public String getRandomWordFromList() {
        int random = (int) (Math.random()*wordlist.size());
        return wordlist.get(random);
    }

    /**
     * Returns all words from wordlist
     * @return returns all words in the List
     */
    public List<String> getAllWords() {
        return this.wordlist;
    }


}
