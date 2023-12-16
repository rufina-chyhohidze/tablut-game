package be.kdg.tablut.data.postgres.repository;

import be.kdg.tablut.data.postgres.entity.BoardFigure;
import be.kdg.tablut.data.postgres.entity.BoardState;
import be.kdg.tablut.data.postgres.mapper.BoardStateMapper;
import be.kdg.tablut.domain.game.Game;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BoardStatePostgresRepository {
    private Connection db;
    public void setDb(Connection db) {
        this.db = db;
    }

    public BoardStatePostgresRepository(Connection db) {
        setDb(db);
    }

    public BoardState getBoardState(int gameStateId) {

        ArrayList<BoardFigure> figures = new ArrayList<>();

        try {
            PreparedStatement st = db.prepareStatement("""
                SELECT
                    int_board_row,
                    int_board_col,
                    int_figure
                  FROM int_board_figures
                  WHERE int_board_id IN (
                    SELECT int_id
                    FROM int_game_boards
                    WHERE int_game_state_id = ?
                  );
            """);
            st.setInt(1, gameStateId);

            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                figures.add(
                        new BoardFigure(
                                rs.getInt("int_board_row"),
                                rs.getInt("int_board_col"),
                                rs.getString("int_figure")
                        )
                );
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }


        return new BoardState(figures.toArray(new BoardFigure[0]));
    }

    public void refreshBoardState(Game game, int gameStateId) {
        dropBoardState(gameStateId);
        createNewBoardState(gameStateId);
        saveNewBoardState(game, gameStateId);
    }

    private void saveNewBoardState(Game game, int boardStateId) {
        BoardState boardState = BoardStateMapper.getBoardStateFromGame(game);

        try {
            for (BoardFigure figure : boardState.getFigures())
            {
                PreparedStatement st = db.prepareStatement("""
                    INSERT INTO int_board_figures (int_board_id, int_board_row, int_board_col, int_figure) 
                    VALUES (?, ?, ?, ?);
                """);

                st.setInt(1, boardStateId);
                st.setInt(2, figure.getRowNumber());
                st.setInt(3, figure.getColNumber());
                st.setString(4, figure.getFigure());

                st.executeUpdate();
            }

            db.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void createNewBoardState(int gameStateId) {
        try{
            PreparedStatement st = db.prepareStatement("""
                INSERT INTO int_game_boards (int_game_state_id) VALUES (?);
            """);

            st.setInt(1, gameStateId);

            st.executeUpdate();

            db.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void dropBoardState(int gameStateId) {
        try{
            PreparedStatement st = db.prepareStatement("""
                DELETE FROM int_game_boards WHERE int_game_state_id = ?''
            """);

            st.setInt(1, gameStateId);

            st.executeUpdate();

            db.commit();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
