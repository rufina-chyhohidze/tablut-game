package be.kdg;

import be.kdg.tablut.domain.figure.Figure;
import be.kdg.tablut.domain.grid.Grid;
import be.kdg.tablut.domain.grid.GridFactory;
import be.kdg.tablut.domain.grid.GridPosition;

public class Main {
    public static void main(String[] args) {
        Grid grid = GridFactory.CreateDefaultGrid();

        for (Figure[] row : grid.getSlots())
        {
            for (Figure figure : row)
            {
                if (figure == null) {
                    System.out.printf("%10s", "X");
                    continue;
                }
                System.out.printf("%10s ", figure);
            }
            System.out.print("\n");
        }

    }
}
