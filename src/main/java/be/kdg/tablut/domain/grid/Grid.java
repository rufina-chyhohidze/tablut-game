package be.kdg.tablut.domain.grid;

import be.kdg.tablut.domain.figure.Figure;

public class Grid {
    private Figure[][] slots;

    public Grid(Figure[][] slots) {
        this.slots = slots;
    }

    public boolean isSlotTaken(int row, int col) {
        return slots[row][col] != null;
    }

    public boolean isSlotFree(int row, int col) {
        return slots[row][col] == null;
    }

}
