package be.kdg.tablut.presentation.ascii.output;

import be.kdg.tablut.domain.game.Game;

public class WelcomeScreenManager {

    public static void printWelcomeScreen(Game game) {
        GameTitleDisplayManager.printGameTitle();

        System.out.printf("Welcome to Tablut, %s\n\n", game.getPlayer().getUsername());

        System.out.println(" ".repeat(25) + "START GAME - S");
        System.out.println(" ".repeat(25) + "RULES - R");
        System.out.println(" ".repeat(25) + "COMMANDS - C");
        System.out.println(" ".repeat(25) + "LEADERBOARD - L");
    }
}
