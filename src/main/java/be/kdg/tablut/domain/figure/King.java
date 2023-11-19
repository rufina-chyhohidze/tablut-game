package be.kdg.tablut.domain.figure;

import be.kdg.tablut.domain.Constants;
import be.kdg.tablut.domain.grid.GridPosition;
import java.util.ArrayList;

public class King extends Figure{

    public King() {
        type = FigureType.KING;
    }

    @Override
    public String toString() {
        return "K";
    }

    @Override
    public GridPosition[] getPossibleMoves(GridPosition currentPosition) {
        ArrayList<GridPosition> possibleMoves = new ArrayList<GridPosition>();

        // Left
        if (currentPosition.col != 0) {
            possibleMoves.add(new GridPosition(currentPosition.row, currentPosition.col - 1));
        }

        // Right
        if (currentPosition.col != Constants.gridSize - 1) {
            possibleMoves.add(new GridPosition(currentPosition.row, currentPosition.col + 1));
        }

        // Top
        if (currentPosition.row != 0) {
            possibleMoves.add(new GridPosition(currentPosition.row - 1, currentPosition.col));
        }

        // Bottom
        if (currentPosition.row != Constants.gridSize - 1) {
            possibleMoves.add(new GridPosition(currentPosition.row + 1, currentPosition.col));
        }


        return possibleMoves.toArray(new GridPosition[0]);
    }

}
