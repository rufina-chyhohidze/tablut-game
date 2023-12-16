package be.kdg.tablut.data.postgres.mapper;

import be.kdg.tablut.data.postgres.entity.BoardState;
import be.kdg.tablut.domain.game.Game;
import be.kdg.tablut.domain.game.GameState;
import be.kdg.tablut.domain.player.Player;

import java.sql.Time;
import java.util.Optional;

public class GameStateMapper {


    public static Optional<GameState> getGameState(
         Player playerWhite,
         Player playerBlack,
         BoardState boardState,
         String turn,
         Time startedAt

    ) {
        // TODO: implement me
        return Optional.empty();
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

    public static Time getStartedAtValueToStore(Game game) {
        return Time.valueOf(game.getStartedAt().toLocalTime());
    }

    public static String getTurnValueToStore(Game game) {
        return game.getMoveTurn().toString();
    }

}
