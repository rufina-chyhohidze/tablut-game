package be.kdg.tablut.domain.board;

import be.kdg.tablut.domain.Constants;
import be.kdg.tablut.domain.figure.Figure;
import be.kdg.tablut.domain.figure.Guard;
import be.kdg.tablut.domain.figure.King;
import be.kdg.tablut.domain.figure.Mercenary;
import be.kdg.tablut.domain.player.Player;

import java.util.HashMap;
import java.util.Map;

public class BoardFactory {

    private static final String whiteWonUsername = "whiteWins";
    private static final String blackLostUsername = "blackLost";

    public static Board provideGameBoard(Player playerWhite, Player playerBlack) {
        if (
                playerWhite.getUsername().equals(whiteWonUsername) &&
                playerBlack.getUsername().equals(blackLostUsername)
        ) {
            return getWhiteWonGrid();
        }

        return getDefaultBoard();
    }


    private static Board getDefaultBoard() {

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

    private static Board getWhiteWonGrid() {
        Figure[][] slots = new Figure[Constants.gridSize][Constants.gridSize];

        Map<BoardPosition, Figure> slotsToFill = new HashMap<BoardPosition, Figure>();

        // King
        slotsToFill.put(new BoardPosition(1, 6), new King());

        // Guards
        slotsToFill.put(new BoardPosition(3, 3), new Guard());

        slotsToFill.put(new BoardPosition(5, 6), new Guard());

        slotsToFill.put(new BoardPosition(6, 3), new Guard());
        slotsToFill.put(new BoardPosition(6, 5), new Guard());

        slotsToFill.put(new BoardPosition(7, 6), new Guard());


        // Mercenaries
        slotsToFill.put(new BoardPosition(0, 4), new Mercenary());
        slotsToFill.put(new BoardPosition(0, 7), new Mercenary());

        slotsToFill.put(new BoardPosition(1, 4), new Mercenary());

        slotsToFill.put(new BoardPosition(2, 6), new Mercenary());

        slotsToFill.put(new BoardPosition(3, 0), new Mercenary());

        slotsToFill.put(new BoardPosition(4, 0), new Mercenary());
        slotsToFill.put(new BoardPosition(4, 1), new Mercenary());
        slotsToFill.put(new BoardPosition(4, 5), new Mercenary());
        slotsToFill.put(new BoardPosition(4, 8), new Mercenary());

        slotsToFill.put(new BoardPosition(5, 0), new Mercenary());

        slotsToFill.put(new BoardPosition(8, 4), new Mercenary());
        slotsToFill.put(new BoardPosition(8, 5), new Mercenary());


        for (Map.Entry<BoardPosition, Figure> e: slotsToFill.entrySet())
            slots[e.getKey().row][e.getKey().col] = e.getValue();

        return new Board(slots);
    }

    public static Board createBoard(Figure[][] slots) {
        return new Board(slots);
    }
}
