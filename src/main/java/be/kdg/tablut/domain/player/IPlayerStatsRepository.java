package be.kdg.tablut.domain.player;

public interface IPlayerStatsRepository {
    void savePlayerWin(Player player);
    void savePlayerLost(Player player);
    void savePlayerDraw(Player player);
}
