package be.kdg.tablut.domain.player.repository;

import be.kdg.tablut.domain.game.Game;
import be.kdg.tablut.domain.player.Player;
import be.kdg.tablut.domain.player.PlayerLeaderboardStats;

public interface IPlayerStatsRepository {
    void savePlayerWin(Player player, Game game);
    void savePlayerLost(Player player, Game game);
    void savePlayerDraw(Player player, Game game);

    PlayerLeaderboardStats[] getPlayerLeaderboardStatus(String username);

    PlayerLeaderboardStats[] getOverallLeaderboard();
}
