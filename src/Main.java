import hangman.ConsoleReader;
import hangman.WordQuiz;
import hangman.WordlistReader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

/**
 * A Class used to invoke and start the WordQuiz
 * 18.04.2019
 * @author Daniel Marten, Maximilian Frömelt, Ruben Klinksiek
 * TODO: .java files in UML2CODE/src can't be recognised
 * TODO: Do Nr. 4 or so from the worksheet
 */
public class Main {

    /**
     * Main Method
     * @param args args
     * @throws IOException IOException
     * @throws NoSuchFieldException NoSuchFieldException
     */
    public static void main(String[] args) throws IOException, NoSuchFieldException {

        ConsoleReader cr = new ConsoleReader(new BufferedReader(new InputStreamReader(System.in)));
        WordlistReader wr = new WordlistReader("res/wordlist.txt");

        WordQuiz daQuiz = new WordQuiz(
                10,
                10,
                cr,
                wr
        );

        daQuiz.playGame();

        cr.closeReader();
    }
}
