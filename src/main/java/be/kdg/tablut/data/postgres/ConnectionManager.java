package be.kdg.tablut.data.postgres;

import io.github.cdimascio.dotenv.Dotenv;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

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
            CREATE TABLE IF NOT EXISTS player_scores (
                player_name varchar(255),
                score numeric(999) default 0,
                game_date timestamp
            );
        """);
    }
}
