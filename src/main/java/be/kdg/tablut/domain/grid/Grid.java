package be.kdg.tablut.domain.grid;

import be.kdg.tablut.domain.Constants;
import be.kdg.tablut.domain.figure.Figure;
import be.kdg.tablut.domain.figure.FigureType;

import java.util.ArrayList;
import java.util.Arrays;

public class Grid {
    private final Figure[][] slots;

    public Figure[][] getSlots() {
        return slots;
    }

    Grid(Figure[][] slots) {
        this.slots = slots;
    }

    public boolean isSlotTaken(GridPosition position) {
        return slots[position.row][position.col] != null;
    }

    public void moveFigure(GridPosition currentPosition, GridPosition targetPosition) throws IllegalArgumentException {

        // TODO: check if targetPosition in Figure.getPossibleMoves() and not taken

        if (!isSlotTaken(currentPosition) || isSlotTaken(targetPosition)) {
            throw new IllegalArgumentException("invalid move data");
        }

        Figure figureToMove = slots[currentPosition.row][currentPosition.col];
        slots[currentPosition.row][currentPosition.col] = null;
        slots[targetPosition.row][targetPosition.col] = figureToMove;

    }

    public GridPosition GetKingPosition() {
        for (int row = 0; row < Constants.gridSize; row++) {
            for (int col = 0; col < Constants.gridSize; col++) {
                Figure figure = slots[row][col];
                if (figure.getType() == FigureType.KING) {
                    return new GridPosition(row, col);
                }
            }
        }
        return null;
    }


    public ArrayList<GridPosition> GetBorderPositions() {
        ArrayList<GridPosition> borderPositions = new ArrayList<>();

        for (int col = 0; col < Constants.gridSize; col++) {
            borderPositions.add(new GridPosition(0, col));
            borderPositions.add(new GridPosition(Constants.gridSize - 1, col));
        }

        for (int row = 0; row < Constants.gridSize; row++) {
            borderPositions.add(new GridPosition(row, 0));
            borderPositions.add(new GridPosition(row, Constants.gridSize - 1));
        }


        return borderPositions;
    }

    public void removeFigure(GridPosition position) {
        slots[position.row][position.col] = null;
    }

}
