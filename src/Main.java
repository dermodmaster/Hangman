import hangman.ConsoleReader;
import hangman.WordQuiz;
import hangman.WordlistReader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {


        WordQuiz daQuiz = new WordQuiz(
                5,
                15,
                new ConsoleReader(new BufferedReader(new InputStreamReader(System.in))),
                new WordlistReader("res/wordlist.txt")
                );

        daQuiz.playGame();

    }



}
