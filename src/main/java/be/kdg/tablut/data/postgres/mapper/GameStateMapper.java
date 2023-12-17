package be.kdg.tablut.data.postgres.mapper;

import be.kdg.tablut.data.postgres.entity.BoardState;
import be.kdg.tablut.domain.board.Board;
import be.kdg.tablut.domain.game.Game;
import be.kdg.tablut.domain.game.GameState;
import be.kdg.tablut.domain.game.MoveTurn;
import be.kdg.tablut.domain.player.Player;

import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Optional;

public class GameStateMapper {


    public static Optional<GameState> getGameState(
         Player playerWhite,
         Player playerBlack,
         BoardState boardState,
         String turn,
         Timestamp startedAt

    ) {
        MoveTurn moveTurn;
        if (turn.equals(MoveTurn.WHITE.toString())) {
            moveTurn = MoveTurn.WHITE;
        } else {
            moveTurn = MoveTurn.BLACK;
        }

        Board board = boardState.toBoard();
        LocalDateTime gameTime = startedAt.toLocalDateTime();

        return Optional.of(
            new GameState(
                playerWhite,
                playerBlack,
                board,
                moveTurn,
                gameTime
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

    public static Timestamp getStartedAtValueToStore(Game game) {
        return Timestamp.valueOf(game.getStartedAt());
    }

    public static String getTurnValueToStore(Game game) {
        return game.getMoveTurn().toString();
    }

}
