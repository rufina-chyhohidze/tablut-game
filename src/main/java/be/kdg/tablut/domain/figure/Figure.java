package be.kdg.tablut.domain.figure;

import be.kdg.tablut.domain.grid.Grid;
import be.kdg.tablut.domain.grid.GridPosition;

public  abstract class Figure {
    protected FigureType type;

    public FigureType getType() {
        return type;
    }

    abstract GridPosition[] getPossibleMoves(GridPosition currentPosition);

}
