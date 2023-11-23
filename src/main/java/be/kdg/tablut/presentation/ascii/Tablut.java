package be.kdg.tablut.presentation.ascii;

import be.kdg.tablut.domain.board.BoardPosition;
import be.kdg.tablut.domain.game.Game;
import be.kdg.tablut.domain.game.MoveTurn;
import be.kdg.tablut.domain.player.Player;
import be.kdg.tablut.presentation.ascii.input.MoveInputManager;
import be.kdg.tablut.presentation.ascii.output.BoardDisplayManager;

public class Tablut {

    private final Game game;

    public Tablut() {
        game = new Game();
    }

    public void playGame() {
        BoardDisplayManager.printGameBoard(game.getBoard());

        BoardPosition playerInput = MoveInputManager.takeMoveInput();
    }
}
