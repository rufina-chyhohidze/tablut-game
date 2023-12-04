package be.kdg.tablut.data.postgres.repository;

import be.kdg.tablut.data.postgres.ConnectionManager;
import be.kdg.tablut.domain.game.Game;
import be.kdg.tablut.domain.game.ScoreManager;
import be.kdg.tablut.domain.player.IPlayerStatsRepository;
import be.kdg.tablut.domain.player.Player;

import java.sql.*;
import java.time.ZoneId;

public class PlayerStatsPostgresRepository implements IPlayerStatsRepository {

    private Connection connection;

    public PlayerStatsPostgresRepository() {
        try {
            this.connection = ConnectionManager.getDBConnection();
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void savePlayerWin(Player player, Game game) {
        System.out.printf("Saving Player %s Win Result...\n\n", player.getUsername());
        try {
        PreparedStatement st = connection.prepareStatement("""
            INSERT INTO player_scores (player_name, score, game_date) VALUES (?, ?, ?);
        """);
            st.setString(1, player.getUsername());
            st.setDouble(2, ScoreManager.getPlayerWonScore(game));
            st.setObject(3, game.getStartedAt());

            st.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            System.out.println("ERROR TODO HANDLING");
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void savePlayerLost(Player player, Game game) {
        System.out.printf("Saving Player %s Lost Result...\n\n", player.getUsername());
        try {
            PreparedStatement st = connection.prepareStatement("""
            INSERT INTO player_scores (player_name, score, game_date) VALUES (?, ?, ?);
        """);
            st.setString(1, player.getUsername());
            st.setDouble(2, ScoreManager.getPlayerLostScore(game));
            st.setObject(3, game.getStartedAt());

            st.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            System.out.println("ERROR TODO HANDLING");
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void savePlayerDraw(Player player, Game game) {
        System.out.println("IMPLEMENT ME");
    }
}
