package be.kdg.tablut.domain.player;

import java.time.LocalDateTime;

public class PlayerLeaderboardStats {

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
