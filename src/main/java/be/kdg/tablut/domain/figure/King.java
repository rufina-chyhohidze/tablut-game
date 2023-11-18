package be.kdg.tablut.domain.figure;

import be.kdg.tablut.domain.grid.Grid;
import be.kdg.tablut.domain.grid.GridPosition;

public class King extends Figure{

    public King() {
        type = FigureType.KING;
    }

    @Override
    public String toString() {
        return "KING";
    }

    @Override
    GridPosition[] getPossibleMoves(GridPosition currentPosition) {
        // TODO:
        return new GridPosition[0];
    }

}
