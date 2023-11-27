package be.kdg.tablut.domain.game;

import be.kdg.tablut.domain.board.Board;
import be.kdg.tablut.domain.board.BoardFactory;
import be.kdg.tablut.domain.board.BoardPosition;
import be.kdg.tablut.domain.figure.Figure;
import be.kdg.tablut.domain.player.Player;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Game {

    private final Board board;
    private MoveTurn moveTurn;
    private final LocalDateTime startedAt;
    private LocalDateTime finishedAt;
    private final Player playerWhite;
    private final Player playerBlack;

    public Game(Player playerWhite, Player playerBlack) {
        this.board = BoardFactory.CreateDefaultBoard();
        this.moveTurn = MoveTurn.WHITE;
        this.startedAt = LocalDateTime.now();
        this.playerWhite = playerWhite;
        this.playerBlack = playerBlack;
    }

    public Board getBoard() {
        return board;
    }

    public MoveTurn getMoveTurn() {
        return moveTurn;
    }
    private void setMoveTurn(MoveTurn moveTurn) {
        this.moveTurn = moveTurn;
    }

    public Player getPlayerWhite() {
        return playerWhite;
    }

    public Player getPlayerBlack() {
        return playerBlack;
    }

    public boolean isGameOver() {
        return (isBlackWin() || isWhiteWin());
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

    private boolean isWhiteWin() {
        BoardPosition kingPosition = board.GetKingPosition();
        ArrayList<BoardPosition> borderPositions = Board.GetBorderPositions();
        return borderPositions.contains(kingPosition);
    }

    private boolean isBlackWin() {
        BoardPosition kingPosition = board.GetKingPosition();

        ArrayList<BoardPosition> positionNeighbors = Board.getPositionNeighbors(kingPosition);

        for (BoardPosition position: positionNeighbors) {
            // if not taken by enemy or taken by guard --> false
            if (
                    (!board.isSlotTaken(position) && !position.isThrone()) ||
                    (board.isSlotTaken(position) && board.getSlots()[position.row][position.col].isWhite)
            ){
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
