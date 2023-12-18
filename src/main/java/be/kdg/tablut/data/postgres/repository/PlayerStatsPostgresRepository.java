package be.kdg.tablut.data.postgres.repository;

import be.kdg.tablut.data.postgres.ConnectionManager;
import be.kdg.tablut.data.postgres.mapper.GameStateMapper;
import be.kdg.tablut.domain.game.Game;
import be.kdg.tablut.domain.game.ScoreManager;
import be.kdg.tablut.domain.player.PlayerLeaderboardStats;
import be.kdg.tablut.domain.player.repository.IPlayerStatsRepository;
import be.kdg.tablut.domain.player.Player;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.time.format.DateTimeFormatter;




public class PlayerStatsPostgresRepository implements IPlayerStatsRepository {
    // TODO: implement me

    private Connection connection;

    public PlayerStatsPostgresRepository() {
        try {

            connection = ConnectionManager.getDBConnection();
        } catch (SQLException e) {

            e.printStackTrace();
        }
    }

    @Override
    public void savePlayerWin(Player player, Game game) {

        String insertQuery = "INSERT INTO INT_player_scores (INT_player_name, INT_score, INT_game_date) VALUES (?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
            preparedStatement.setString(1, player.getUsername());
            preparedStatement.setDouble(2, ScoreManager.getPlayerWonScore(game));
            preparedStatement.setTimestamp(3, new Timestamp(System.currentTimeMillis()));

            preparedStatement.executeUpdate();
            connection.commit();

        } catch (SQLException e) {

            e.printStackTrace();
        }
    }

    @Override
    public void savePlayerLost(Player player, Game game) {
        String insertQuery = "INSERT INTO INT_player_scores (INT_player_name, INT_score, INT_game_date) VALUES (?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
            preparedStatement.setString(1, player.getUsername());
            preparedStatement.setDouble(2, ScoreManager.getPlayerLostScore(game));
            preparedStatement.setTimestamp(3, new Timestamp(System.currentTimeMillis()));

            preparedStatement.executeUpdate();
            connection.commit();
        } catch (SQLException e) {

            e.printStackTrace();
        }
    }

    @Override
    public void savePlayerDraw(Player player, Game game) {
        System.out.println("IMPLEMENT ME");
    }

    @Override
    public PlayerLeaderboardStats[] getPlayerLeaderboardStatus(String username) {
        List<PlayerLeaderboardStats> leaderboardStatsList = new ArrayList<>();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
            """
                    SELECT 
                        INT_player_name,
                        INT_score,
                        INT_game_date
                    FROM INT_player_scores 
                    WHERE int_player_name = ?
                    ORDER BY INT_score DESC
                    FETCH FIRST 5 ROWS WITH TIES;
                """
            );
            preparedStatement.setString(1, username);

            ResultSet resultSet = preparedStatement.executeQuery();


            while (resultSet.next()) {
                String playerName = resultSet.getString("INT_player_name");
                double score = resultSet.getDouble("INT_score");
                Timestamp gameDate = resultSet.getTimestamp("INT_game_date");

                PlayerLeaderboardStats leaderboardStats = new PlayerLeaderboardStats(
                        playerName,
                        score,
                        gameDate.toLocalDateTime()
                );

                leaderboardStatsList.add(leaderboardStats);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return leaderboardStatsList.toArray(new PlayerLeaderboardStats[0]);
    }

}


