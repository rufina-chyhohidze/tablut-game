package be.kdg.tablut.domain.game.factory;

import be.kdg.tablut.di.RepositoryProvider;
import be.kdg.tablut.domain.game.Game;
import be.kdg.tablut.domain.game.GameState;
import be.kdg.tablut.domain.game.repository.IGameStateRepository;
import be.kdg.tablut.domain.player.Player;

import java.util.Optional;

public class GameFactory {
    public static Game newGame(Player playerWhite, Player playerBlack) {
        IGameStateRepository repository = RepositoryProvider.provideGameStateRepository();
        Game defaultGame =  new Game(playerWhite, playerBlack);

        if (repository == null) {
            return defaultGame;
        }

        Optional<GameState> currentState = repository.getGameStateByPlayers(playerWhite, playerBlack);

        if (currentState.isEmpty()) {
            System.out.println("No state found. Default Game Launching...");
            return defaultGame;
        }

        defaultGame.setBoard(currentState.get().getBoard());
        defaultGame.setStartedAt(currentState.get().getStartedAt());
        defaultGame.setMoveTurn(currentState.get().getTurn());

        return defaultGame;
    }

}
