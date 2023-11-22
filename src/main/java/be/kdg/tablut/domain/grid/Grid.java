package be.kdg.tablut.domain.grid;

import be.kdg.tablut.domain.Constants;
import be.kdg.tablut.domain.figure.Figure;
import be.kdg.tablut.domain.figure.FigureType;

import java.util.ArrayList;

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

    public static ArrayList<GridPosition> getPositionNeighbors(GridPosition currentPosition) {
        ArrayList<GridPosition> neighbors = new ArrayList<>();

        // Left
        if (currentPosition.col != 0) {
            neighbors.add(new GridPosition(currentPosition.row, currentPosition.col - 1));
        }

        // Right
        if (currentPosition.col != Constants.gridSize - 1) {
            neighbors.add(new GridPosition(currentPosition.row, currentPosition.col + 1));
        }

        // Top
        if (currentPosition.row != 0) {
            neighbors.add(new GridPosition(currentPosition.row -1, currentPosition.col));
        }

        // Bottom
        if (currentPosition.row != Constants.gridSize - 1) {
            neighbors.add(new GridPosition(currentPosition.row +1, currentPosition.col));
        }

        return neighbors;
    }

    public static ArrayList<GridPosition> GetBorderPositions() {
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

    public void moveFigure(GridPosition currentPosition, GridPosition targetPosition) throws IllegalArgumentException {

        Figure figureToMove = slots[currentPosition.row][currentPosition.col];
        ArrayList<GridPosition> possibleMoves = figureToMove.getPossibleMoves(currentPosition);

        if (!possibleMoves.contains(targetPosition)) {
            throw new IllegalArgumentException("invalid move data");
        }


        if (!isSlotTaken(currentPosition) || isSlotTaken(targetPosition) || targetPosition.isThrone()) {
            throw new IllegalArgumentException("invalid move data");
        }

        slots[currentPosition.row][currentPosition.col] = null;
        slots[targetPosition.row][targetPosition.col] = figureToMove;

    }

    private void removeFigure(GridPosition position) {
        slots[position.row][position.col] = null;
    }


    private ArrayList<GridPosition> getPositionsBetweenPositions(
            GridPosition currentPosition,
            GridPosition targetPosition
    ) {
        ArrayList<GridPosition> positionsBetween = new ArrayList<>();

        if (
                (currentPosition.row != targetPosition.row) &&
                (currentPosition.col != targetPosition.col)
        ) {
            return positionsBetween;
        }

        if (currentPosition.row == targetPosition.row) {
            for (
                    int col = Math.min(currentPosition.col, targetPosition.col);
                    col < Math.max(currentPosition.col, targetPosition.col);
                    col++
            ){
                positionsBetween.add(new GridPosition(currentPosition.row, col));
            }
            return positionsBetween;
        }



        return positionsBetween;
    }
}
