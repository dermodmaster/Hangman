import hangman.ConsoleReader;
import hangman.WordQuiz;
import hangman.WordlistReader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException, NoSuchFieldException {


        WordQuiz daQuiz = new WordQuiz(
                10,
                10,
                new ConsoleReader(new BufferedReader(new InputStreamReader(System.in))),
                new WordlistReader("res/wordlist.txt")
        );

        daQuiz.playGame();

    }



}
