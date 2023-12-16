package be.kdg.tablut.domain.player;

import java.time.LocalDateTime;
import java.time.LocalTime;

public class PlayerLeaderboardStats {

    public PlayerLeaderboardStats(
            String playerName,
            Double gameScore,
            LocalDateTime gameDate
    ) {
        this.playerName = playerName;
        this.gameDate = gameDate;
        this.gameScore = gameScore;
    }


    private String playerName;

    public String getPlayerName() {
        return playerName;
    }

    private Double gameScore;

    public Double getGameScore() {
        return gameScore;
    }

    private LocalDateTime gameDate;

    public LocalDateTime getGameDate() {
        return gameDate;
    }
}
