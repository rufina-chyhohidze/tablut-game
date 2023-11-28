package be.kdg.tablut.di;

import be.kdg.tablut.domain.player.IPlayerStatsRepository;
import be.kdg.tablut.domain.player.PlayerStatsRepositoryMock;

public class RepositoryProvider {
    public static IPlayerStatsRepository providePlayerStatsRepository(){
        // TODO: add DB Repository implementation
        return new PlayerStatsRepositoryMock();
    }
}
