package be.kdg.tablut.presentation.ascii;

import be.kdg.tablut.domain.board.BoardPosition;
import be.kdg.tablut.domain.game.Game;
import be.kdg.tablut.domain.player.Player;
import be.kdg.tablut.presentation.ascii.input.CommandInputManager;
import be.kdg.tablut.presentation.ascii.input.MoveInputManager;
import be.kdg.tablut.presentation.ascii.output.*;

public class Tablut {

    private final Game game;

    public Tablut(Player playerWhite, Player playerBlack) {
        game = new Game(playerWhite, playerBlack);
    }

    public void start() {
        WelcomeScreenManager.printWelcomeScreen(game);
        takeAndHandleCommandInput();
    }

    private void takeAndHandleCommandInput() {
        CommandDisplayManager.printCommands();
        AsciiConstants.CommandType playerInput = CommandInputManager.takeCommandInput();
        handleCommandInput(playerInput);
    }

    private void handleCommandInput(AsciiConstants.CommandType commandType) {
        switch (commandType) {
            case START -> {
                playGame();
            }
            case RULES -> {
                showRules();
            }
            case COMMANDS -> {
                showCommands();
            }
            case LEADERBOARD -> {

            }
            default -> {
                System.out.println("TODO");
            }
        }
    }

    private void playGame() {

        while (!game.isGameOver()) {
            // Show Board
            BoardDisplayManager.printGameBoard(game.getBoard());

            // Show who makes the move
            TurnDisplayManager.printGameTurn(game);

            // Move Player
            takeAndHandleMoveInput();
        }

        System.out.println("Game Over!");
    }

    private void showRules() {
        RulesDisplayManager.displayRules();
        takeAndHandleCommandInput();
    }

    private void showCommands() {
        takeAndHandleCommandInput();
    }

    private void showLeaderBoard() {
        System.out.println("TODO");
    }

    private void takeAndHandleMoveInput() {

        while (true) {
            BoardPosition currentPosition = MoveInputManager.takeCurrentPositionInput();
            BoardPosition targetPosition = MoveInputManager.takeTargetPositionInput();

            try{
                game.makeMove(currentPosition, targetPosition);
                return;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
