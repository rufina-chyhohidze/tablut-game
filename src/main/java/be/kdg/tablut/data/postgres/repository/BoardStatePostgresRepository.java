package be.kdg.tablut.data.postgres.repository;

import java.sql.Connection;

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
}
