package be.kdg.tablut.presentation.ascii.output;

public class EndGameScreenManager {
    public static void printEndGameScreen() {
        GameTitleDisplayManager.printGameTitle();
        System.out.println("-".repeat(82) + "\n" +
                "|Thanks for playing! You can check out anytime you like, but you can never leave |\n" +
                "|(you know you want to play again)" + " ".repeat(47) + "|\n" +
                "-".repeat(82));
    }
}
