package be.kdg.tablut.presentation.ascii.output;

import be.kdg.tablut.domain.game.Game;

public class WinnerDisplayManager {

    public static void printGameWinner(Game game) {
        if (game.isBlackWin()) {
            System.out.printf("Congratulations, %s. You Won!\n\n", game.getPlayerBlack().getUsername());
        } else {
            System.out.printf("Congratulations, %s. You Won!\n\n", game.getPlayerWhite().getUsername());
        }
    }

}
