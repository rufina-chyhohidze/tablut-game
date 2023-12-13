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

        initTables(conn);

        return conn;
    }

    public static void initTables(Connection conn) throws SQLException {
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
                 white_username varchar(255),
                 black_username varchar(255),
                 turn varchar(255) not null ,
                 started_At time not null ,
                 board varchar(255) not null ,
                 PRIMARY KEY (white_username, black_username)
             );
        """);

        conn.commit();
    }
}
