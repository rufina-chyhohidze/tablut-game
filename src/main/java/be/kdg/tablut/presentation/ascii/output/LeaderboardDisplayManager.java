
package be.kdg.tablut.presentation.ascii.output;

import be.kdg.tablut.domain.player.Player;
import be.kdg.tablut.domain.player.PlayerLeaderboardStats;

import java.time.LocalDateTime;
import java.time.LocalTime;

public class LeaderboardDisplayManager {

    public static void printLeaderBoard(String username, PlayerLeaderboardStats[] leaderboardStats) {
        System.out.println("-".repeat(86));
        System.out.println("|USERNAME" + " ".repeat(18) + "|SCORE" + " ".repeat(21) + "|TIME" + "\n"
                + "-".repeat(86));
        for (PlayerLeaderboardStats playerStat : leaderboardStats) {
            System.out.printf("|%-25s|%-25s|%-30s|\n", playerStat.getPlayerName(), playerStat.getGameScore(), playerStat.getGameDate()  + "\n" +
                    "-".repeat(86));
        }
    }

    //test for leaderboard displaying
    public static void main(String[] args){
        System.out.println("-".repeat(86));
        System.out.println("|USERNAME" + " ".repeat(18) + "|SCORE" + " ".repeat(21) + "|TIME" + "\n"
        + "-".repeat(86));
       PlayerLeaderboardStats leaderboard = new PlayerLeaderboardStats("abc",35.5, LocalDateTime.now());
       PlayerLeaderboardStats monkey = new PlayerLeaderboardStats("abcdefghijklmnop",1000.1,LocalDateTime.now());
        System.out.printf("|%-25s |%-25s |%-30s\n",leaderboard.getPlayerName(), leaderboard.getGameScore(),LocalTime.now() + "\n" +
                "-".repeat(86));
        System.out.printf("|%-25s |%-25s |%-30s\n", monkey.getPlayerName(), monkey.getGameScore(), monkey.getGameDate() + "\n" +
                "-".repeat(86) + "\n");
    }
    
}
