package be.kdg.tablut.domain.game;

public class ScoreManager {

    public static double getPlayerWonScore(Game game) {
        return 1.5 * getGameDuration(game);
    }

    public static double getPlayerLostScore(Game game) {
        return 0.5 * getGameDuration(game);
    }


    private static double getGameDuration(Game game) {
        return 1.;
    }

}
