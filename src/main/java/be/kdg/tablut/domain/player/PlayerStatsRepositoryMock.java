package be.kdg.tablut.domain.player;

public class PlayerStatsRepositoryMock implements IPlayerStatsRepository{
    @Override
    public void savePlayerWin(Player player) {
        System.out.printf("Saving Player %s win result...\n\n", player.getUsername());
    }

    @Override
    public void savePlayerLost(Player player) {
        System.out.printf("Saving Player %s lost result...\n\n", player.getUsername());
    }

    @Override
    public void savePlayerDraw(Player player) {
        System.out.printf("Saving Player %s draw result...\n\n", player.getUsername());
    }
}
