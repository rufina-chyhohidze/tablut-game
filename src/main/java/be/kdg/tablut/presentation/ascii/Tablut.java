package be.kdg.tablut.presentation.ascii;

import be.kdg.tablut.domain.game.Game;
import be.kdg.tablut.domain.player.Player;
import be.kdg.tablut.presentation.ascii.input.CommandInputManager;
import be.kdg.tablut.presentation.ascii.output.BoardDisplayManager;
import be.kdg.tablut.presentation.ascii.output.TurnDisplayManager;
import be.kdg.tablut.presentation.ascii.output.WelcomeScreenManager;

public class Tablut {

    private final Game game;

    public Tablut(Player playerWhite, Player playerBlack) {
        game = new Game(playerWhite, playerBlack);
    }

    public void start() {
        WelcomeScreenManager.printWelcomeScreen(game);

        AsciiConstants.CommandType playerInput = CommandInputManager.takeCommandInput();

        handleCommandInput(playerInput);
    }

    private void handleCommandInput(AsciiConstants.CommandType commandType) {
        switch (commandType) {
            case START -> {
                playGame();
            }
            default -> {
                System.out.println("TODO");
            }
        }
    }

    private void playGame() {
        BoardDisplayManager.printGameBoard(game.getBoard());
        TurnDisplayManager.printGameTurn(game);
    }

    private void showRules() {

    }

}
