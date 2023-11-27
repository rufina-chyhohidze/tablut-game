package be.kdg.tablut.presentation.ascii.output;

import be.kdg.tablut.domain.game.Game;
import be.kdg.tablut.domain.game.MoveTurn;

import java.util.Objects;

public class TurnDisplayManager {
    public static void printGameTurn(Game game) {

        MoveTurn currentTurn = game.getMoveTurn();

        if (Objects.requireNonNull(currentTurn) == MoveTurn.BLACK) {
            System.out.println("BLACK player makes move");
        } else {
            System.out.println("WHITE player makes move");
        }
    }
}
