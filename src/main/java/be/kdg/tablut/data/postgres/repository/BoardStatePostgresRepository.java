package be.kdg.tablut.data.postgres.repository;

import be.kdg.tablut.data.postgres.entity.BoardFigure;
import be.kdg.tablut.data.postgres.entity.BoardState;
import be.kdg.tablut.domain.game.Game;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BoardStatePostgresRepository {
    private Connection db;
    public Connection getDb() {
        return db;
    }

    public void setDb(Connection db) {
        this.db = db;
    }

    public BoardStatePostgresRepository(Connection db) {
        setDb(db);
    }

    public BoardState getBoardState(Game game, int gameStateId) {

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
    };

}
