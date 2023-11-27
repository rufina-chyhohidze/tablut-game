package be.kdg.tablut.presentation.ascii;

import be.kdg.tablut.domain.board.BoardPosition;
import be.kdg.tablut.domain.game.Game;
import be.kdg.tablut.presentation.ascii.input.MoveInputManager;
import be.kdg.tablut.presentation.ascii.output.BoardDisplayManager;
import be.kdg.tablut.presentation.ascii.output.GameTitleDisplayManager;

public class Tablut {

    private final Game game;

    public Tablut() {
        game = new Game(null);
    }

    public void playGame() {
        GameTitleDisplayManager.printGameTitle();

        BoardDisplayManager.printGameBoard(game.getBoard());

        BoardPosition playerInput = MoveInputManager.takePositionInput();
        System.out.printf("%s %s", playerInput.row, playerInput.col);
    }
}
