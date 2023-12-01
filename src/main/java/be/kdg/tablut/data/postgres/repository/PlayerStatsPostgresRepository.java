package be.kdg.tablut.data.postgres.repository;

import be.kdg.tablut.data.postgres.ConnectionManager;
import be.kdg.tablut.domain.game.Game;
import be.kdg.tablut.domain.player.IPlayerStatsRepository;
import be.kdg.tablut.domain.player.Player;

import java.sql.Connection;
import java.sql.SQLException;

public class PlayerStatsPostgresRepository implements IPlayerStatsRepository {

    private Connection connection;

    public PlayerStatsPostgresRepository() {
        try {
            this.connection = ConnectionManager.getDBConnection();
        } catch (SQLException ignored){}
    }

    @Override
    public void savePlayerWin(Player player, Game game) {
    }

    @Override
    public void savePlayerLost(Player player, Game game) {

    }

    @Override
    public void savePlayerDraw(Player player, Game game) {

    }
}
