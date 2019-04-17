package hangman;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Klasse zum lesen einer Liste mit zu erratenden Wörtern aus einer Textdatei
 * 17.04.2019
 * @author Daniel Marten
 */
public class WordlistReader {

    private List<String> wordlist;
    private String src = "C:\\Users\\GRKE\\Desktop\\Galgenmännchen\\src\\hangman\\wordlist.txt";

    /**
     * Constructor for WordlistReader
     * @param string zu erratendes Wort
     */
    public WordlistReader(String string){

    }

    /**
     * Reads a specified file into a List
     * @return true if done correctly, else false
     */
    protected boolean readListFromFile(){

        List<String> result = new ArrayList<>();

        try(BufferedReader br = new BufferedReader(new FileReader(src))){
            result.add(br.lines().collect(Collectors.joining(System.lineSeparator())));
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

        for (String str : wordlist){
            if (str.length()==length){
                result.add(str);
            }
        }
        return result;
    }

    /**
     * Returns all words from wordlist
     * @return
     */
    public List<String> getAllWords() {
        return this.wordlist;
    }




}
