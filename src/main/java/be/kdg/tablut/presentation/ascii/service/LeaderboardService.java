package be.kdg.tablut.presentation.ascii.service;

import be.kdg.tablut.di.RepositoryProvider;
import be.kdg.tablut.domain.game.Game;
import be.kdg.tablut.domain.player.IPlayerStatsRepository;
import be.kdg.tablut.domain.player.Player;

public class LeaderboardService {
    private final IPlayerStatsRepository repository;

    public LeaderboardService() {
        this.repository = RepositoryProvider.providePlayerStatsRepository();
    }

    public void handleGameOver(Game game) {
        Player playerWon = getPlayerWon(game);
        repository.savePlayerWin(playerWon, game);

        Player playerLost = getPlayerLost(game);
        repository.savePlayerLost(playerLost, game);
    }

    private Player getPlayerWon(Game game) {
        if (game.isBlackWin()) {
            return game.getPlayerBlack();
        }
        return game.getPlayerWhite();
    }

    private Player getPlayerLost(Game game) {
        if (game.isBlackWin()) {
            return game.getPlayerWhite();
        }
        return game.getPlayerBlack();
    }

}
