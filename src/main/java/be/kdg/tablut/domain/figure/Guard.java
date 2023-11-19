package be.kdg.tablut.domain.figure;

import be.kdg.tablut.domain.grid.GridPosition;

public class Guard extends Figure{
    public Guard() {
        type = FigureType.GUARD;
    }

    @Override
    public String toString() {
        return "G";
    }

    @Override
    public GridPosition[] getPossibleMoves(GridPosition currentPosition) {
        // TODO:
        return new GridPosition[0];
    }
}
