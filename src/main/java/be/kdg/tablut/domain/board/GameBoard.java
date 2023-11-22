package be.kdg.tablut.domain.board;

import be.kdg.tablut.domain.grid.Grid;
import be.kdg.tablut.domain.grid.GridFactory;
import be.kdg.tablut.domain.grid.GridPosition;

import java.util.ArrayList;
import java.util.Optional;

public class GameBoard {

    public GameBoard() {
        this.grid = GridFactory.CreateDefaultGrid();
        this.moveTurn = MoveTurn.WHITE;
        this.winner = null;
    }

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

    private MoveTurn winner;
    public MoveTurn getWinner() {
        return winner;
    }
    private void setWinner(MoveTurn winner) {
        this.winner = winner;
    }

    public boolean isGameOver() {
        return (isBlackWin() || isWhiteWin());
    }

    private boolean isWhiteWin() {
        GridPosition kingPosition = grid.GetKingPosition();
        ArrayList<GridPosition> borderPositions = Grid.GetBorderPositions();
        return borderPositions.contains(kingPosition);
    }

    private boolean isBlackWin() {
        GridPosition kingPosition = grid.GetKingPosition();

        ArrayList<GridPosition> positionNeighbors = Grid.getPositionNeighbors(kingPosition);

        for (GridPosition position: positionNeighbors) {
            if (!grid.isSlotTaken(position) && !position.isThrone()){
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
}
