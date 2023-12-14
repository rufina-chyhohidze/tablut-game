package be.kdg.tablut.data.postgres.mapper;

import be.kdg.tablut.domain.game.Game;

import java.sql.Time;

public class GameStateMapper {
    public static String getWhitePlayerStoreValue(Game game) {
        return game.getPlayerWhite().getUsername();
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
