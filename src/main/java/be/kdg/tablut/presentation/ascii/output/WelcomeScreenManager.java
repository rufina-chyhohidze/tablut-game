package be.kdg.tablut.presentation.ascii.output;

import be.kdg.tablut.domain.game.Game;

public class WelcomeScreenManager {

    public static void printWelcomeScreen(Game game) {
        GameTitleDisplayManager.printGameTitle();

        System.out.printf("Welcome to Tablut, %s\n\n", game.getPlayerWhite().getUsername());
        System.out.printf("Welcome to Tablut, %s\n\n", game.getPlayerBlack().getUsername());

    }
}
