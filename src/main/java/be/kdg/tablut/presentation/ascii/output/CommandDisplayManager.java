package be.kdg.tablut.presentation.ascii.output;

public class CommandDisplayManager {
    public static void printCommands() {
        System.out.println(" ".repeat(25) + "-".repeat(19) + "\n" +
                " ".repeat(25) + "| START GAME - S  | \n" +
                " ".repeat(25) + "-".repeat(19) + "\n" +
                "\n" +
                " ".repeat(25) + "-".repeat(19) + "\n" +
                " ".repeat(25) + "| RULES - R       | \n" +
                " ".repeat(25) + "-".repeat(19) + "\n" +
                "\n" +
                " ".repeat(25) + "-".repeat(19) + "\n" +
                " ".repeat(25) + "| COMMANDS - C    | \n" +
                " ".repeat(25) + "-".repeat(19) + "\n" +
                "\n" +
                " ".repeat(25) + "-".repeat(19) + "\n" +
                " ".repeat(25) + "| LEADERBOARD - L | \n" +
                " ".repeat(25) + "-".repeat(19));
    }
}
