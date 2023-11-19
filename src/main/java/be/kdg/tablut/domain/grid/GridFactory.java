package be.kdg.tablut.domain.grid;

import be.kdg.tablut.domain.Constants;
import be.kdg.tablut.domain.figure.Figure;
import be.kdg.tablut.domain.figure.Guard;
import be.kdg.tablut.domain.figure.King;
import be.kdg.tablut.domain.figure.Mercenary;

import java.util.HashMap;
import java.util.Map;

public class GridFactory {
    public static Grid CreateDefaultGrid() {

        Figure[][] slots = new Figure[Constants.gridSize][Constants.gridSize];

        Map<GridPosition, Figure> slotsToFill = new HashMap<GridPosition, Figure>();

        // King
        slotsToFill.put(new GridPosition(4, 4), new King());

        // Guards
        slotsToFill.put(new GridPosition(2, 4), new Guard());

        slotsToFill.put(new GridPosition(3, 4), new Guard());

        slotsToFill.put(new GridPosition(4, 2), new Guard());
        slotsToFill.put(new GridPosition(4, 3), new Guard());
        slotsToFill.put(new GridPosition(4, 5), new Guard());
        slotsToFill.put(new GridPosition(4, 6), new Guard());

        slotsToFill.put(new GridPosition(5, 4), new Guard());
        slotsToFill.put(new GridPosition(6, 4), new Guard());


        // Mercenaries
        slotsToFill.put(new GridPosition(0, 3), new Mercenary());
        slotsToFill.put(new GridPosition(0, 4), new Mercenary());
        slotsToFill.put(new GridPosition(0, 5), new Mercenary());

        slotsToFill.put(new GridPosition(1, 4), new Mercenary());

        slotsToFill.put(new GridPosition(3, 0), new Mercenary());
        slotsToFill.put(new GridPosition(3, 8), new Mercenary());

        slotsToFill.put(new GridPosition(4, 0), new Mercenary());
        slotsToFill.put(new GridPosition(4, 1), new Mercenary());
        slotsToFill.put(new GridPosition(4, 7), new Mercenary());
        slotsToFill.put(new GridPosition(4, 8), new Mercenary());

        slotsToFill.put(new GridPosition(5, 0), new Mercenary());
        slotsToFill.put(new GridPosition(5, 8), new Mercenary());

        slotsToFill.put(new GridPosition(7, 4), new Mercenary());

        slotsToFill.put(new GridPosition(8, 3), new Mercenary());
        slotsToFill.put(new GridPosition(8, 4), new Mercenary());
        slotsToFill.put(new GridPosition(8, 5), new Mercenary());


        for (Map.Entry<GridPosition, Figure> e: slotsToFill.entrySet())
            slots[e.getKey().row][e.getKey().col] = e.getValue();

        return new Grid(slots);
    }

}
