package be.kdg.tablut.domain.game;

import be.kdg.tablut.domain.board.Board;
import be.kdg.tablut.domain.player.Player;

import java.time.LocalDateTime;

public class GameState {
    private Player playerWhite;
    private Player playerBlack;
    private Board board;

    private MoveTurn turn;

    private LocalDateTime startedAt;

    public Player getPlayerBlack() {
        return playerBlack;
    }

    public Player getPlayerWhite() {
        return playerWhite;
    }

    public Board getBoard() {
        return board;
    }

    public MoveTurn getTurn() {
        return turn;
    }

    public LocalDateTime getStartedAt() {
        return startedAt;
    }
}
