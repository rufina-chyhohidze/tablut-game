package be.kdg.tablut.data.postgres.repository;

import be.kdg.tablut.data.postgres.ConnectionManager;
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
            preparedStatement.setDouble(2, ScoreManager.getPlayerWonScore());
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
            preparedStatement.setDouble(2, ScoreManager.getPlayerLostScore());
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

        String sqlQuery = "SELECT INT_player_name, INT_score, INT_game_date FROM INT_player_scores ORDER BY INT_score DESC LIMIT 5";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        try (PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                String playerName = resultSet.getString("INT_player_name");
                double score = resultSet.getDouble("INT_score");
                Timestamp gameDate = resultSet.getTimestamp("INT_game_date");

                // Создайте объект PlayerLeaderboardStats и добавьте его в список
                PlayerLeaderboardStats leaderboardStats = new PlayerLeaderboardStats();
                leaderboardStatsList.add(leaderboardStats);


                System.out.printf("Player: %-15s, Score: %-5.2f, Game Date: %s%n", playerName, score, gameDate.toLocalDateTime().format(formatter));
            }

        } catch (SQLException e) {
            e.printStackTrace();
            // Обработка исключений, связанных с базой данных
        }

        // Преобразуйте список в массив и верните его
        return leaderboardStatsList.toArray(new PlayerLeaderboardStats[0]);
    }

}


