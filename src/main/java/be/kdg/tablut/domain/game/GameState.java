package be.kdg.tablut.domain.game;

import be.kdg.tablut.domain.board.Board;
import be.kdg.tablut.domain.player.Player;

import java.time.LocalDateTime;

public class GameState {

    public GameState(
        Player playerWhite,
        Player playerBlack,
        Board board,
        MoveTurn turn,
        LocalDateTime startedAt

    ) {
        this.setPlayerWhite(playerWhite);
        this.setPlayerBlack(playerBlack);
        this.setBoard(board);
        this.setTurn(turn);
        this.setStartedAt(startedAt);
    }

    private Player playerWhite;
    private Player playerBlack;
    private Board board;

    private MoveTurn turn;

    private LocalDateTime startedAt;

    public Player getPlayerBlack() {
        return playerBlack;
    }

    public void setPlayerBlack(Player playerBlack) {
        this.playerBlack = playerBlack;
    }

    public Player getPlayerWhite() {
        return playerWhite;
    }

    public void setPlayerWhite(Player playerWhite) {
        this.playerWhite = playerWhite;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public MoveTurn getTurn() {
        return turn;
    }

    public void setTurn(MoveTurn turn) {
        this.turn = turn;
    }

    public LocalDateTime getStartedAt() {
        return startedAt;
    }

    public void setStartedAt(LocalDateTime startedAt) {
        this.startedAt = startedAt;
    }
}
