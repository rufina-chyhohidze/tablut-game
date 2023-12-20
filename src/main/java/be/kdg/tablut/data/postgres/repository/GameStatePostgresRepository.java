package be.kdg.tablut.data.postgres.repository;

import be.kdg.tablut.data.postgres.ConnectionManager;
import be.kdg.tablut.data.postgres.entity.BoardState;
import be.kdg.tablut.data.postgres.mapper.GameStateMapper;
import be.kdg.tablut.domain.game.Game;
import be.kdg.tablut.domain.game.GameState;
import be.kdg.tablut.domain.game.repository.IGameStateRepository;
import be.kdg.tablut.domain.player.Player;

import javax.swing.text.html.Option;
import java.sql.*;
import java.util.Optional;

public class GameStatePostgresRepository  implements IGameStateRepository {

    private final Connection db;
    private final BoardStatePostgresRepository boardStateRepository;

    public GameStatePostgresRepository() throws Exception{
        this.db = ConnectionManager.getDBConnection();
        this.boardStateRepository = new BoardStatePostgresRepository(db);
    }

    @Override
    public Optional<GameState> getGameStateByPlayers(Player playerWhite, Player playerBlack) {
        try {
            PreparedStatement st = db.prepareStatement("""
                SELECT 
                    int_id,
                    int_seconds_played,
                    int_turn
                FROM int_game_states 
                WHERE 
                    int_white_username = ? AND
                    int_black_username = ? 
            ;
            """);

            st.setString(1, GameStateMapper.getWhitePlayerStoreValue(playerWhite));
            st.setString(2, GameStateMapper.getBlackPlayerStoreValue(playerBlack));

            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                int gameStateId = rs.getInt("int_id");
                int secondsPlayed = rs.getInt("int_seconds_played");

                String turn = rs.getString("int_turn");

                BoardState boardState = boardStateRepository.getBoardState(gameStateId);

                return GameStateMapper.getGameState(
                        playerWhite,
                        playerBlack,
                        boardState,
                        turn,
                        secondsPlayed
                );
            }

            return Optional.empty();

        } catch (SQLException e) {
            e.printStackTrace();
            return Optional.empty();
        }
    }

    @Override
    public void saveGameState(Game game) {

        Optional<GameState> currentState = getGameStateByPlayers(game.getPlayerWhite(), game.getPlayerBlack());

        if (currentState.isEmpty()) {
            createGameState(game);
            return;
        }

        updateGameState(game);
    }

    @Override
    public void dropGameState(Game game) {
        try {
            PreparedStatement st = db.prepareStatement("""
                DELETE FROM int_game_states 
                WHERE INT_black_username = ? AND INT_white_username = ?;          
            """);

            st.setString(1, GameStateMapper.getBlackPlayerStoreValue(game));
            st.setString(2, GameStateMapper.getWhitePlayerStoreValue(game));

            st.executeUpdate();
            db.commit();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    private void updateGameState(Game game) {
        try {
            PreparedStatement st = db.prepareStatement("""
                    UPDATE int_game_states 
                    SET
                        INT_turn = ?,
                        int_seconds_played = int_seconds_played + ?
                    WHERE INT_black_username = ? AND INT_white_username = ?;
            """);

            st.setString(1, GameStateMapper.getTurnValueToStore(game));
            st.setLong(2, GameStateMapper.getSecondsPlayed(game));
            st.setString(3, GameStateMapper.getBlackPlayerStoreValue(game));
            st.setString(4, GameStateMapper.getWhitePlayerStoreValue(game));


            st.executeUpdate();

            Optional<Integer> gameStateId = getGameStateId(game);
            if (gameStateId.isEmpty()) {
                System.out.println("no game state found. Skipping...");
                return;
            }

            boardStateRepository.refreshBoardState(game, gameStateId.get());

            db.commit();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void createGameState(Game game) {
        try {
            PreparedStatement st = db.prepareStatement("""
                    INSERT INTO int_game_states 
                        (int_white_username, int_black_username, int_turn, int_seconds_played) 
                    VALUES (
                        ?, ?, ?, ?
                    );
            """);

            st.setString(1, GameStateMapper.getWhitePlayerStoreValue(game));
            st.setString(2, GameStateMapper.getBlackPlayerStoreValue(game));
            st.setString(3, GameStateMapper.getTurnValueToStore(game));
            st.setLong(4, GameStateMapper.getSecondsPlayed(game));

            st.executeUpdate();

            Optional<Integer> gameStateId = getGameStateId(game);
            if (gameStateId.isEmpty()) {
                return;
            }

            System.out.println(gameStateId.get());

            boardStateRepository.refreshBoardState(game, gameStateId.get());

            db.commit();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private Optional<Integer> getGameStateId(Game game) {
        try {
            PreparedStatement st = db.prepareStatement("""
                SELECT int_id FROM int_game_states
                WHERE int_white_username = ? AND int_black_username = ?;
            """);

            st.setString(1, GameStateMapper.getWhitePlayerStoreValue(game));
            st.setString(2,  GameStateMapper.getBlackPlayerStoreValue(game));

            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                return Optional.of(rs.getInt("int_id"));
            }

            return Optional.empty();

        } catch (SQLException e) {
            e.printStackTrace();
            return Optional.empty();
        }
    }

}
