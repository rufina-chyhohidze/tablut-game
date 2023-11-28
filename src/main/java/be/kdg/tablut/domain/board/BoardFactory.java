package be.kdg.tablut.domain.board;

import be.kdg.tablut.domain.Constants;
import be.kdg.tablut.domain.figure.Figure;
import be.kdg.tablut.domain.figure.Guard;
import be.kdg.tablut.domain.figure.King;
import be.kdg.tablut.domain.figure.Mercenary;

import java.util.HashMap;
import java.util.Map;

public class BoardFactory {

    public static Board CreateDefaultBoard() {

        Figure[][] slots = new Figure[Constants.gridSize][Constants.gridSize];

        Map<BoardPosition, Figure> slotsToFill = new HashMap<BoardPosition, Figure>();

        // King
        slotsToFill.put(new BoardPosition(4, 4), new King());

        // Guards
        slotsToFill.put(new BoardPosition(2, 4), new Guard());

        slotsToFill.put(new BoardPosition(3, 4), new Guard());

        slotsToFill.put(new BoardPosition(4, 2), new Guard());
        slotsToFill.put(new BoardPosition(4, 3), new Guard());
        slotsToFill.put(new BoardPosition(4, 5), new Guard());
        slotsToFill.put(new BoardPosition(4, 6), new Guard());

        slotsToFill.put(new BoardPosition(5, 4), new Guard());
        slotsToFill.put(new BoardPosition(6, 4), new Guard());


        // Mercenaries
        slotsToFill.put(new BoardPosition(0, 3), new Mercenary());
        slotsToFill.put(new BoardPosition(0, 4), new Mercenary());
        slotsToFill.put(new BoardPosition(0, 5), new Mercenary());

        slotsToFill.put(new BoardPosition(1, 4), new Mercenary());

        slotsToFill.put(new BoardPosition(3, 0), new Mercenary());
        slotsToFill.put(new BoardPosition(3, 8), new Mercenary());

        slotsToFill.put(new BoardPosition(4, 0), new Mercenary());
        slotsToFill.put(new BoardPosition(4, 1), new Mercenary());
        slotsToFill.put(new BoardPosition(4, 7), new Mercenary());
        slotsToFill.put(new BoardPosition(4, 8), new Mercenary());

        slotsToFill.put(new BoardPosition(5, 0), new Mercenary());
        slotsToFill.put(new BoardPosition(5, 8), new Mercenary());

        slotsToFill.put(new BoardPosition(7, 4), new Mercenary());

        slotsToFill.put(new BoardPosition(8, 3), new Mercenary());
        slotsToFill.put(new BoardPosition(8, 4), new Mercenary());
        slotsToFill.put(new BoardPosition(8, 5), new Mercenary());


        for (Map.Entry<BoardPosition, Figure> e: slotsToFill.entrySet())
            slots[e.getKey().row][e.getKey().col] = e.getValue();

        return new Board(slots);
    }

    public static Board getWhiteWonGrid() {
        Figure[][] slots = new Figure[Constants.gridSize][Constants.gridSize];
        slots[0][0] = new King();
        return new Board(slots);
    }

}
