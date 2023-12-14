package be.kdg.tablut.data.postgres.repository;

import be.kdg.tablut.data.postgres.entity.BoardState;
import be.kdg.tablut.domain.game.Game;

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

    public BoardState getBoardState(Game game) {
        // TODO: implement me
        return null;
    }

}
