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
        int secondsPlayed

    ) {
        this.setPlayerWhite(playerWhite);
        this.setPlayerBlack(playerBlack);
        this.setBoard(board);
        this.setTurn(turn);
        this.setSecondsPlayed(secondsPlayed);
    }

    private Player playerWhite;
    private Player playerBlack;
    private Board board;

    private MoveTurn turn;

    private int secondsPlayed;

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

    public int getSecondsPlayed() {
        return secondsPlayed;
    }

    private void setSecondsPlayed(int secondsPlayed) {
        this.secondsPlayed = secondsPlayed;
    }
}
