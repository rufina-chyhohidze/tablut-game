package be.kdg.tablut.domain.game;

import be.kdg.tablut.domain.board.Board;
import be.kdg.tablut.domain.board.BoardFactory;
import be.kdg.tablut.domain.board.BoardPosition;
import be.kdg.tablut.domain.figure.Figure;
import be.kdg.tablut.domain.player.Player;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;

public class Game {

    public Game() {
        this.board = BoardFactory.CreateDefaultBoard();
        this.moveTurn = MoveTurn.WHITE;
        this.winner = null;
        this.startedAt = LocalDateTime.now();
    }

    private final Board board;
    public Board getBoard() {
        return board;
    }

    private final LocalDateTime startedAt;
    private LocalDateTime finishedAt;

    private MoveTurn moveTurn;
    public MoveTurn getMoveTurn() {
        return moveTurn;
    }
    private void setMoveTurn(MoveTurn moveTurn) {
        this.moveTurn = moveTurn;
    }

    private MoveTurn winner;
    public MoveTurn getWinner() {
        return winner;
    }
    private void setWinner(MoveTurn winner) {
        this.winner = winner;
    }

    public void makeMove(BoardPosition currentPosition, BoardPosition moveTo) throws IllegalArgumentException  {

        Figure figureToMove = board.getSlots()[currentPosition.row][currentPosition.col];
        if (!isFigureTurn(figureToMove)) {
            throw new IllegalArgumentException("Invalid Figure to move");
        }

        if (!board.canMoveTo(currentPosition, moveTo)) {
            throw new IllegalArgumentException("Invalid Move");
        }

        board.moveFigure(currentPosition, moveTo);
        switchTurn();
    }

    public boolean isGameOver() {
        return (isBlackWin() || isWhiteWin());
    }

    private boolean isWhiteWin() {
        BoardPosition kingPosition = board.GetKingPosition();
        ArrayList<BoardPosition> borderPositions = Board.GetBorderPositions();
        return borderPositions.contains(kingPosition);
    }

    private boolean isBlackWin() {
        BoardPosition kingPosition = board.GetKingPosition();

        ArrayList<BoardPosition> positionNeighbors = Board.getPositionNeighbors(kingPosition);

        for (BoardPosition position: positionNeighbors) {
            if (!board.isSlotTaken(position) && !position.isThrone()){
                return false;
            }
        }

        return true;
    }

    private void switchTurn() {
        if (moveTurn == MoveTurn.WHITE) {
            setMoveTurn(MoveTurn.BLACK);
            return;
        }

        setMoveTurn(MoveTurn.WHITE);
    }

    private boolean isFigureTurn(Figure figure) {
        return (
                (figure.isWhite && moveTurn == MoveTurn.WHITE) ||
                (!figure.isWhite && moveTurn == MoveTurn.BLACK)
        );
    }
}
