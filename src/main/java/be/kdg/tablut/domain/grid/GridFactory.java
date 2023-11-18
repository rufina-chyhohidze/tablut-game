package be.kdg.tablut.domain.grid;

import be.kdg.tablut.domain.figure.Figure;
import be.kdg.tablut.domain.figure.FigureFactory;

import java.util.HashMap;
import java.util.Map;

public class GridFactory {
    public static Grid CreateDefaultGrid() {

        Figure[][] slots = new Figure[9][9];

        Map<GridPosition, Figure> slotsToFill = new HashMap<GridPosition, Figure>();

        // King
        slotsToFill.put(new GridPosition(4, 4), FigureFactory.CreateKing());

        // Guards
        slotsToFill.put(new GridPosition(2, 4), FigureFactory.CreateGuard());

        slotsToFill.put(new GridPosition(3, 4), FigureFactory.CreateGuard());

        slotsToFill.put(new GridPosition(4, 2), FigureFactory.CreateGuard());
        slotsToFill.put(new GridPosition(4, 3), FigureFactory.CreateGuard());
        slotsToFill.put(new GridPosition(4, 5), FigureFactory.CreateGuard());
        slotsToFill.put(new GridPosition(4, 6), FigureFactory.CreateGuard());

        slotsToFill.put(new GridPosition(5, 4), FigureFactory.CreateGuard());
        slotsToFill.put(new GridPosition(6, 4), FigureFactory.CreateGuard());


        // Mercenaries
        slotsToFill.put(new GridPosition(0, 3), FigureFactory.CreateMercenary());
        slotsToFill.put(new GridPosition(0, 4), FigureFactory.CreateMercenary());
        slotsToFill.put(new GridPosition(0, 5), FigureFactory.CreateMercenary());

        slotsToFill.put(new GridPosition(1, 4), FigureFactory.CreateMercenary());

        slotsToFill.put(new GridPosition(3, 0), FigureFactory.CreateMercenary());
        slotsToFill.put(new GridPosition(3, 8), FigureFactory.CreateMercenary());

        slotsToFill.put(new GridPosition(4, 0), FigureFactory.CreateMercenary());
        slotsToFill.put(new GridPosition(4, 1), FigureFactory.CreateMercenary());
        slotsToFill.put(new GridPosition(4, 7), FigureFactory.CreateMercenary());
        slotsToFill.put(new GridPosition(4, 8), FigureFactory.CreateMercenary());

        slotsToFill.put(new GridPosition(5, 0), FigureFactory.CreateMercenary());
        slotsToFill.put(new GridPosition(5, 8), FigureFactory.CreateMercenary());

        slotsToFill.put(new GridPosition(7, 4), FigureFactory.CreateMercenary());

        slotsToFill.put(new GridPosition(8, 3), FigureFactory.CreateMercenary());
        slotsToFill.put(new GridPosition(8, 4), FigureFactory.CreateMercenary());
        slotsToFill.put(new GridPosition(8, 5), FigureFactory.CreateMercenary());


        for (Map.Entry<GridPosition, Figure> e: slotsToFill.entrySet())
            slots[e.getKey().row][e.getKey().col] = e.getValue();

        return new Grid(slots);
    }

}
