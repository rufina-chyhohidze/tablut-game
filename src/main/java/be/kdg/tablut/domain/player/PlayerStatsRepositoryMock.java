package be.kdg.tablut.domain.player;

import be.kdg.tablut.domain.game.Game;

public class PlayerStatsRepositoryMock implements IPlayerStatsRepository{
    @Override
    public void savePlayerWin(Player player, Game game) {
        System.out.printf("Saving Player %s win result...\n\n", player.getUsername());
    }

    @Override
    public void savePlayerLost(Player player, Game game) {
        System.out.printf("Saving Player %s lost result...\n\n", player.getUsername());
    }

    @Override
    public void savePlayerDraw(Player player, Game game) {
        System.out.printf("Saving Player %s draw result...\n\n", player.getUsername());
    }
}
