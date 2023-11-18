package be.kdg;

import be.kdg.tablut.domain.figure.Figure;
import be.kdg.tablut.domain.grid.Grid;
import be.kdg.tablut.domain.grid.GridFactory;

public class Main {
    public static void main(String[] args) {
        Grid grid = GridFactory.CreateDefaultGrid();

        for (Figure[] row : grid.getGrid())
        {
            for (Figure figure : row)
            {
                System.out.printf("%10s ", figure);
            }
            System.out.print("\n");
        }

    }
}
