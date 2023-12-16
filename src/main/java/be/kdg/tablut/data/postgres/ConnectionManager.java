package be.kdg.tablut.data.postgres;

import io.github.cdimascio.dotenv.Dotenv;

import java.sql.*;

public class ConnectionManager {
    public static Connection getDBConnection() throws SQLException {
        Dotenv dotenv = Dotenv.load();
        String dsn = dotenv.get("JDBC_POSTGRES_URL");
        String username = dotenv.get("JDBC_POSTGRES_DB_USERNAME");
        String password = dotenv.get("JDBC_POSTGRES_DB_PASSWORD");

        Connection conn = DriverManager.getConnection(dsn, username, password);
        conn.setAutoCommit(false);

        return conn;
    }

    public static void initTables() throws SQLException {
        Connection conn = getDBConnection();

        Statement st = conn.createStatement();

        st.execute(""" 
            CREATE TABLE IF NOT EXISTS INT_player_scores (
             INT_id SERIAL primary key,
             INT_player_name varchar(20),
             INT_score numeric(10) default 0,
             INT_game_date timestamp
            );
        """);

        st.execute("""
            CREATE TABLE IF NOT EXISTS INT_game_states (
                 INT_id SERIAL PRIMARY KEY,
                 INT_white_username varchar(255),
                 INT_black_username varchar(255),
                 INT_turn varchar(255) not null,
                 INT_started_At timestamp not null
            );
            """
        );

        st.execute("""
            CREATE TABLE IF NOT EXISTS INT_game_boards (
                INT_id SERIAL PRIMARY KEY,
                INT_game_state_id int not null
                    constraint fk_game_boards_game_state_id
                    references INT_game_states on delete cascade
            );"""
        );


        st.execute("""
            CREATE TABLE IF NOT EXISTS INT_board_figures (
                INT_board_id INT NOT NULL
                    constraint fk_board_figure_board_id
                    references INT_game_boards on delete cascade,
                INT_board_row INT NOT NULL,
                INT_board_col INT NOT NULL,
                INT_figure varchar(10) NOT NULL,
                PRIMARY KEY (INT_board_id, INT_board_row, INT_board_col)
            );
            """
        );

        conn.commit();
    }
}
