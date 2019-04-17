import hangman.ConsoleReader;
import hangman.WordlistReader;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

public class Main {

    public static void main(String[] args){


        //WordlistReader wr = new WordlistReader("Test");
        //System.out.println(wr.getAllWords());

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ConsoleReader reader = new ConsoleReader(br);
        System.out.println(reader.readNextChar());

    }



}
