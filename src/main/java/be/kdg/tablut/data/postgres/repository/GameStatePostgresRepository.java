package be.kdg.tablut.data.postgres.repository;

import be.kdg.tablut.data.postgres.ConnectionManager;
import be.kdg.tablut.data.postgres.mapper.GameStateMapper;
import be.kdg.tablut.domain.game.Game;
import be.kdg.tablut.domain.game.GameState;
import be.kdg.tablut.domain.game.repository.IGameStateRepository;
import be.kdg.tablut.domain.player.Player;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Optional;

public class GameStatePostgresRepository  implements IGameStateRepository {

    private final Connection db;

    public GameStatePostgresRepository() throws Exception{
        this.db = ConnectionManager.getDBConnection();
    }


    @Override
    public Optional<GameState> getGameStateByPlayers(Player playerWhite, Player playerBlack) {
        return Optional.empty();
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
                WHERE black_username = ? AND white_username = ?;          
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
                        board=?,
                        turn=?
                    WHERE black_username = ? AND white_username = ?;
            """);

            st.setString(1, GameStateMapper.getBoardValueToSave(game));
            st.setString(2, GameStateMapper.getTurnValueToStore(game));
            st.setString(3, GameStateMapper.getBlackPlayerStoreValue(game));
            st.setString(4, GameStateMapper.getWhitePlayerStoreValue(game));

            st.executeUpdate();
            db.commit();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void createGameState(Game game) {
        try {
            PreparedStatement st = db.prepareStatement("""
                    INSERT INTO int_game_states 
                        (white_username, black_username, turn, started_at, board) 
                    VALUES (
                        ?, ?, ?, ?, ?
                    );
            """);

            st.setString(1, GameStateMapper.getWhitePlayerStoreValue(game));
            st.setString(2, GameStateMapper.getBlackPlayerStoreValue(game));
            st.setString(3, GameStateMapper.getTurnValueToStore(game));

            st.setTime(4, GameStateMapper.getStartedAtValueToStore(game));
            st.setString(5, GameStateMapper.getBoardValueToSave(game));

            st.executeUpdate();
            db.commit();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
