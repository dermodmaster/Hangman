package hangman;

/**
 * Class for printing ACII art
 * 19.04.2019
 * @author Daniel Marten, Maximilian Frömelt, Ruben Klinksiek
 */
public class WordQuizAsciiArt {

    /**
     * String for ACII hangman art
     */
    private static String[] art = {
                    "                \n" +          // 0
                    "                \n" +
                    "                \n" +
                    "                \n" +
                    "                \n" +
                    "                 \n" +
                    "                \n" +
                    "   _ ___        ",

                    "                \n" +          // 1
                    "                \n" +
                    "                \n" +
                    "                \n" +
                    "    |           \n" +
                    "    |            \n" +
                    "    |           \n" +
                    "   _|___        ",

                    "                \n" +          // 2
                    "    |           \n" +
                    "    |           \n" +
                    "    |           \n" +
                    "    |           \n" +
                    "    |            \n" +
                    "    |           \n" +
                    "   _|___        ",

                    "     ___        \n" +          // 3
                    "    |           \n" +
                    "    |           \n" +
                    "    |           \n" +
                    "    |           \n" +
                    "    |            \n" +
                    "    |           \n" +
                    "   _|___        ",

                    "     _______    \n" +          // 4
                    "    |           \n" +
                    "    |           \n" +
                    "    |           \n" +
                    "    |           \n" +
                    "    |            \n" +
                    "    |           \n" +
                    "   _|___        ",

                    "     _______    \n" +          // 5
                    "    | /         \n" +
                    "    |/          \n" +
                    "    |           \n" +
                    "    |           \n" +
                    "    |            \n" +
                    "    |           \n" +
                    "   _|___        ",

                    "     _______    \n" +          // 6
                    "    | /     |   \n" +
                    "    |/          \n" +
                    "    |           \n" +
                    "    |           \n" +
                    "    |            \n" +
                    "    |           \n" +
                    "   _|___        ",

                    "     _______    \n" +          // 7
                    "    | /     |   \n" +
                    "    |/     (_)  \n" +
                    "    |           \n" +
                    "    |           \n" +
                    "    |            \n" +
                    "    |           \n" +
                    "   _|___        ",

                    "     _______    \n" +          // 8
                    "    | /     |   \n" +
                    "    |/     (_)  \n" +
                    "    |       |   \n" +
                    "    |           \n" +
                    "    |            \n" +
                    "    |           \n" +
                    "   _|___        ",

                    "     _______    \n" +          // 9
                    "    | /     |   \n" +
                    "    |/     (_)  \n" +
                    "    |      \\|   \n" +
                    "    |           \n" +
                    "    |            \n" +
                    "    |           \n" +
                    "   _|___        ",

                    "     _______    \n" +          // 10
                    "    | /     |   \n" +
                    "    |/     (_)  \n" +
                    "    |      \\|/  \n" +
                    "    |           \n" +
                    "    |            \n" +
                    "    |           \n" +
                    "   _|___        ",

                    "     _______    \n" +          // 11
                    "    | /     |   \n" +
                    "    |/     (_)  \n" +
                    "    |      \\|/  \n" +
                    "    |       |   \n" +
                    "    |            \n" +
                    "    |           \n" +
                    "   _|___        ",

                    "     _______    \n" +          // 12
                    "    | /     |   \n" +
                    "    |/     (_)  \n" +
                    "    |      \\|/  \n" +
                    "    |       |   \n" +
                    "    |      /     \n" +
                    "    |           \n" +
                    "   _|___        ",

                    "     _______    \n" +          // 13
                    "    | /     |   \n" +
                    "    |/     (_)  \n" +
                    "    |      \\|/  \n" +
                    "    |       |   \n" +
                    "    |      / \\  \n" +
                    "    |           \n" +
                    "   _|___        ",
                    "     _______    \n" +          // 14
                    "    | /     |   \n" +
                    "    |/     (x)  \n" +
                    "    |      \\|/  \n" +
                    "    |       |   \n" +
                    "    |      / \\  \n" +
                    "    |           \n" +
                    "   _|___        ",

    };

    /**
     * Constructor for WordQuizAsciiArt
     */
    public WordQuizAsciiArt() {
        for(int i= 14; i > -1; i--) {
            System.out.printf("printArt(%d)%n", i);
            printArt(i);
        }
    }

    /**
     * Prints the art
     * @param remainingAttempts remaining Attempts
     */
    public static void printArt(int remainingAttempts) {
        if (remainingAttempts > 14)
            remainingAttempts = 14;

        if (remainingAttempts < 0)
            remainingAttempts = 0;

        System.out.println(art[14-remainingAttempts]);
    }


}
