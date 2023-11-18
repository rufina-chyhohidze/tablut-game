package be.kdg.tablut.domain.grid;

import be.kdg.tablut.domain.figure.Figure;

public class Grid {
    private final Figure[][] slots;

    public Figure[][] getSlots() {
        return slots;
    }

    public Grid(Figure[][] slots) {
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
}
