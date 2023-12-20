package be.kdg.tablut.domain.game;

import be.kdg.tablut.domain.player.Player;

import java.util.Optional;

public class ScoreManager {

    public static double getPlayerWonScore(Game game) {
        Optional<Player> player = game.getPlayerWon();
        if (player.isEmpty()) {
            return 15;
        }

        int playerFigureCount = game.getBoard().getFiguresCountByColor(
                player.get().getColor() == MoveTurn.WHITE
        );

        int opponentFigureCount = game.getBoard().getFiguresCountByColor(
                player.get().getColor() != MoveTurn.WHITE
        );

        return 15 *  Math.max(playerFigureCount, opponentFigureCount);
    }

    public static double getPlayerLostScore(Game game) {
        Optional<Player> player = game.getPlayerLost();
        if (player.isEmpty()) {
            return 5;
        }

        int playerFigureCount = game.getBoard().getFiguresCountByColor(
                player.get().getColor() == MoveTurn.WHITE
        );

        int opponentFigureCount = game.getBoard().getFiguresCountByColor(
                player.get().getColor() != MoveTurn.WHITE
        );

        return 5 * Math.min(playerFigureCount, opponentFigureCount);
    }
}
