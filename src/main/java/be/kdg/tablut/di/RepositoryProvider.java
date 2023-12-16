package be.kdg.tablut.di;

import be.kdg.tablut.data.postgres.repository.GameStatePostgresRepository;
import be.kdg.tablut.data.postgres.repository.PlayerStatsPostgresRepository;
import be.kdg.tablut.domain.game.Game;
import be.kdg.tablut.domain.game.repository.IGameStateRepository;
import be.kdg.tablut.domain.player.repository.IPlayerStatsRepository;

import java.security.interfaces.EdECKey;

public class RepositoryProvider {
    public static IPlayerStatsRepository providePlayerStatsRepository(){
        return new PlayerStatsPostgresRepository();
    }

    public static IGameStateRepository provideGameStateRepository() {
        try{
            return new GameStatePostgresRepository();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
