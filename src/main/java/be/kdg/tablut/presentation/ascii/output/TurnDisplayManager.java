package be.kdg.tablut.presentation.ascii.output;

import be.kdg.tablut.domain.game.Game;
import be.kdg.tablut.domain.game.MoveTurn;

import java.util.Objects;

public class TurnDisplayManager {
    public static void printGameTurn(Game game) {

        String displayTurn;

        MoveTurn currentTurn = game.getMoveTurn();

        if (Objects.requireNonNull(currentTurn) == MoveTurn.BLACK) {
            displayTurn = "BLACK";
        } else {
            displayTurn = "WHITE";
        }

        System.out.printf("\n%s player moves \n", displayTurn);
    }
}
