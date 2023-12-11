package be.kdg.tablut.presentation.ascii.output;

import be.kdg.tablut.domain.player.Player;
import be.kdg.tablut.domain.player.PlayerLeaderboardStats;

public class LeaderboardDisplayManager {

    public static void printLeaderBoard(String username, PlayerLeaderboardStats[] leaderboardStats) {
        // TODO: implement me
        for (PlayerLeaderboardStats playerStat : leaderboardStats) {
            System.out.printf("|  %s| %s | %s|\n", playerStat.getPlayerName(),playerStat.getGameDate(), playerStat.getGameScore());
        }
    }
    
}
