package be.kdg.tablut.domain.player;

import be.kdg.tablut.domain.game.Game;

public interface IPlayerStatsRepository {
    void savePlayerWin(Player player, Game game);
    void savePlayerLost(Player player, Game game);
    void savePlayerDraw(Player player, Game game);
}
