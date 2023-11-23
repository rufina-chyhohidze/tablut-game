package be.kdg.tablut.presentation.ascii;

import be.kdg.tablut.domain.game.Game;

public class Tablut {

    private final Game game;

    public Tablut() {
        game = new Game();
    }

    public void playGame() {
        BoardDisplayManager.printGameBoard(game.getBoard());
    }

}
