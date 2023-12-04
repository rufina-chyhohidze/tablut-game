package be.kdg.tablut.di;

import be.kdg.tablut.data.postgres.repository.PlayerStatsPostgresRepository;
import be.kdg.tablut.domain.player.IPlayerStatsRepository;

public class RepositoryProvider {
    public static IPlayerStatsRepository providePlayerStatsRepository(){
        return new PlayerStatsPostgresRepository();
    }
}
