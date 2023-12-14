package be.kdg.tablut.presentation.ascii;

import be.kdg.tablut.data.postgres.ConnectionManager;
import be.kdg.tablut.domain.board.BoardPosition;
import be.kdg.tablut.domain.game.Game;
import be.kdg.tablut.domain.player.Player;
import be.kdg.tablut.presentation.ascii.input.AuthorizationManager;
import be.kdg.tablut.presentation.ascii.input.CommandInputManager;
import be.kdg.tablut.presentation.ascii.input.EndGameCommandInputManager;
import be.kdg.tablut.presentation.ascii.input.MoveInputManager;
import be.kdg.tablut.presentation.ascii.output.*;
import be.kdg.tablut.presentation.ascii.service.LeaderboardService;

public class Tablut {

    private Game game;
    private final LeaderboardService leaderboardService;

    public Tablut() {
        try{
            ConnectionManager.initTables();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        Player playerWhite = AuthorizationManager.authorizeWhitePlayer();
        Player playerBlack = AuthorizationManager.authorizeBlackPlayer();
        game = new Game(playerWhite, playerBlack);
        leaderboardService = new LeaderboardService();
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

    private void takeAndHandleEndGameCommandInput() {
        EndGameCommandsManager.printEndGameCommands();
        AsciiConstants.EndGameCommand command = EndGameCommandInputManager.takeEndGameCommandInput();
        handleEndGameCommand(command);
    }

    private void handleCommandInput(AsciiConstants.CommandType commandType) {
        switch (commandType) {
            case START -> playGame();

            case RULES -> showRules();

            case COMMANDS -> showCommands();

            case LEADERBOARD -> showLeaderBoard();

            default -> System.out.println("TODO");
        }
    }

    private void handleEndGameCommand(AsciiConstants.EndGameCommand command) {
        switch (command) {
            case RESTART -> {
                reset();
                start();
            }
            case QUIT -> {
                EndGameScreenManager.printEndGameScreen();
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
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ignored) {}

        gameOver();
    }

    private void gameOver() {
        System.out.println("Saving Game Result...");
        leaderboardService.handleGameOver(game);

        try {
            Thread.sleep(1000);
        } catch (InterruptedException ignored) {}

        leaderboardService.printPlayerLeaderboard();

        try {
            Thread.sleep(500);
        } catch (InterruptedException ignored) {}

        takeAndHandleEndGameCommandInput();
    }

    private void showRules() {
        RulesDisplayManager.displayRules();
        takeAndHandleCommandInput();
    }

    private void showCommands() {
        takeAndHandleCommandInput();
    }

    private void showLeaderBoard() {
        leaderboardService.printPlayerLeaderboard();
        takeAndHandleCommandInput();
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

    private void reset() {
        Player playerWhite = AuthorizationManager.authorizeWhitePlayer();
        Player playerBlack = AuthorizationManager.authorizeBlackPlayer();
        this.game = new Game(playerWhite, playerBlack);
    }
}
