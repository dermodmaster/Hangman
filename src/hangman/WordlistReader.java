package hangman;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Klasse zum lesen einer Liste mit zu erratenden Wörtern aus einer Textdatei
 * 17.04.2019
 * @author Daniel Marten
 * TODO: relocate wordlist to resource folder
 */
public class WordlistReader {

    private List<String> wordlist;
    private String src;

    /**
     * Constructor for WordlistReader
     * @param filepath zu erratendes Wort
     */
    public WordlistReader(String filepath){
        this.wordlist = new ArrayList<>();
        this.src = filepath;
        readListFromFile();
    }

    /**
     * Reads a specified file into a List
     * @return true if done correctly, else false
     */
    protected boolean readListFromFile(){

        try(BufferedReader br = new BufferedReader(new FileReader(src))){
            String line;
            while ((line = br.readLine()) != null){
                wordlist.add(line);
            }
            return true;
        }
        catch (IOException e){
            e.printStackTrace();
            return false;
        }
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

    /**
     * Returns all words from wordlist
     * @return returns all words in the List
     */
    public List<String> getAllWords() {
        return this.wordlist;
    }




}
