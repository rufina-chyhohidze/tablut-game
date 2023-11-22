package be.kdg.tablut.domain.board;

import be.kdg.tablut.domain.grid.Grid;
import be.kdg.tablut.domain.grid.GridFactory;
import be.kdg.tablut.domain.grid.GridPosition;

import java.util.ArrayList;
import java.util.Optional;

public class GameBoard {
    private final Grid grid;
    public Grid getGrid() {
        return grid;
    }
    private MoveTurn moveTurn;

    public MoveTurn getMoveTurn() {
        return moveTurn;
    }
    private void setMoveTurn(MoveTurn moveTurn) {
        this.moveTurn = moveTurn;
    }
    private Optional<MoveTurn> winner;

    public Optional<MoveTurn> getWinner() {
        return winner;
    }
    private void setWinner(Optional<MoveTurn> winner) {
        this.winner = winner;
    }

    public GameBoard() {
        grid = GridFactory.CreateDefaultGrid();
        moveTurn = MoveTurn.WHITE;
    }
    public boolean isGameOver() {
        return winner.isPresent();
    }

    private void switchTurn() {
        if (moveTurn == MoveTurn.WHITE) {
            setMoveTurn(MoveTurn.BLACK);
            return;
        }

        setMoveTurn(MoveTurn.WHITE);
    }


    private boolean isWhiteWin() {
        GridPosition kingPosition = grid.GetKingPosition();
        ArrayList<GridPosition> borderPositions = grid.GetBorderPositions();
        return borderPositions.contains(kingPosition);
    }

}
