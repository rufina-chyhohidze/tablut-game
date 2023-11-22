package be.kdg.tablut.domain.figure;

import be.kdg.tablut.domain.Constants;
import be.kdg.tablut.domain.grid.GridPosition;

import java.util.ArrayList;

public  abstract class Figure {
    protected FigureType type;

    public FigureType getType() {
        return type;
    }

    public ArrayList<GridPosition> getPossibleMoves(GridPosition currentPosition) {
        ArrayList<GridPosition> possibleMoves = new ArrayList<GridPosition>();

        // Horizontal
        for (int col = 0; col < Constants.gridSize; col++) {
            if (col == currentPosition.col) {
                continue;
            }
            possibleMoves.add(new GridPosition(currentPosition.row, col));
        }

        // Vertical
        for (int row = 0; row < Constants.gridSize; row++) {
            if (row == currentPosition.row) {
                continue;
            }
            possibleMoves.add(new GridPosition(row, currentPosition.col));
        }

        return possibleMoves;
    }

}
