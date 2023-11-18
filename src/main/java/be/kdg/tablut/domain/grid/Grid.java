package be.kdg.tablut.domain.grid;

import be.kdg.tablut.domain.figure.Figure;

public class Grid {
    private Figure[][] grid;

    public Figure[][] getGrid() {
        return grid;
    }

    public Grid(Figure[][] slots) {
        this.grid = slots;
    }


}
