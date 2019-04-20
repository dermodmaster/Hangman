package hangman;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

/**
 * Klasse zum lesen einer Liste mit zu erratenden Wörtern aus einer Textdatei
 * 17.04.2019
 * @author Daniel Marten, Maximilian Frömelt, Ruben Klinksiek
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
        if (!readListFromFile())
            throw new IOException("Exception on file read");
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
     * @throws NoSuchFieldException if not a single word of this length is found
     */
    public List<String> getWordsOfLength(int length) throws NoSuchFieldException {
        List<String> result = new ArrayList<>();

        for (String word : wordlist){
            if (word.length()==length){
                result.add(word);
            }
        }

        if (result.size() == 0) throw new NoSuchFieldException("No Word of this length found!");
        return result;

    }

    /**
     * Retrieves a random word of the specified length from wordlist
     * @param wordLength length of the word
     * @return word of the length
     * @throws NoSuchFieldException Couldn't find word matching request
     */
    public String getRandomWordWithLengthFromList(int wordLength) throws NoSuchFieldException {
        List<String> tmp = getWordsOfLength(wordLength);
        int random = (int) (Math.random()*tmp.size());
        return tmp.get(random);
    }

    /**
     * Returns all words from wordlist
     * @return returns all words in the List
     */
    public List<String> getAllWords() {
        return this.wordlist;
    }


}
