package be.kdg.tablut.data.postgres.mapper;

import be.kdg.tablut.data.postgres.entity.BoardState;
import be.kdg.tablut.domain.board.Board;
import be.kdg.tablut.domain.game.Game;
import be.kdg.tablut.domain.game.GameState;
import be.kdg.tablut.domain.game.MoveTurn;
import be.kdg.tablut.domain.player.Player;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Optional;

public class GameStateMapper {


    public static Optional<GameState> getGameState(
         Player playerWhite,
         Player playerBlack,
         BoardState boardState,
         String turn,
         int secondsPlayed

    ) {
        MoveTurn moveTurn;
        if (turn.equals(MoveTurn.WHITE.toString())) {
            moveTurn = MoveTurn.WHITE;
        } else {
            moveTurn = MoveTurn.BLACK;
        }

        Board board = boardState.toBoard();

        return Optional.of(
            new GameState(
                playerWhite,
                playerBlack,
                board,
                moveTurn,
                secondsPlayed
            )
        );
    };

    public static String getWhitePlayerStoreValue(Game game) {
        return game.getPlayerWhite().getUsername();
    }

    public static String getWhitePlayerStoreValue(Player player) {
        return player.getUsername();
    }

    public static String getBlackPlayerStoreValue(Player player) {
        return player.getUsername();
    }

    public static String getBlackPlayerStoreValue(Game game) {
        return game.getPlayerBlack().getUsername();
    }

    public static String getTurnValueToStore(Game game) {
        return game.getMoveTurn().toString();
    }

    public static long getSecondsPlayed(Game game) {
        return Math.abs(Duration.between(LocalDateTime.now(), game.getStartedAt()).toSeconds());
    }

}
