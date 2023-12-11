package be.kdg.tablut.data.postgres.repository;

import be.kdg.tablut.data.postgres.ConnectionManager;
import be.kdg.tablut.domain.game.Game;
import be.kdg.tablut.domain.game.ScoreManager;
import be.kdg.tablut.domain.player.PlayerLeaderboardStats;
import be.kdg.tablut.domain.player.repository.IPlayerStatsRepository;
import be.kdg.tablut.domain.player.Player;

import java.sql.*;

public class PlayerStatsPostgresRepository implements IPlayerStatsRepository {
    // TODO: implement me

    private Connection connection;

    public PlayerStatsPostgresRepository() {
    }

    @Override
    public void savePlayerWin(Player player, Game game) {
    }

    @Override
    public void savePlayerLost(Player player, Game game) {

    }

    @Override
    public void savePlayerDraw(Player player, Game game) {
        System.out.println("IMPLEMENT ME");
    }

    @Override
    public PlayerLeaderboardStats[] getPlayerLeaderboardStatus(String username) {
        return new PlayerLeaderboardStats[0];
    }

    @Override
    public PlayerLeaderboardStats[] getOverallLeaderboard() {
        return new PlayerLeaderboardStats[0];
    }

}
