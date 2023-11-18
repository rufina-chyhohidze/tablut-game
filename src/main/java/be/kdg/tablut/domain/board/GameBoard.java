package be.kdg.tablut.domain.board;

import be.kdg.tablut.domain.grid.Grid;
import be.kdg.tablut.domain.grid.GridFactory;

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

    public GameBoard() {
        grid = GridFactory.CreateDefaultGrid();
        moveTurn = MoveTurn.WHITE;
    }
}
