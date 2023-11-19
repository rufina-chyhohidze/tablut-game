package be.kdg;

import be.kdg.tablut.domain.board.GameBoard;
import be.kdg.tablut.domain.figure.Figure;

public class Main {
    public static void main(String[] args) {

        GameBoard gameBoard = new GameBoard();

        // TODO: move all printing to presentation layer
        for (Figure[] row : gameBoard.getGrid().getSlots())
        {
            for (Figure figure : row)
            {
                if (figure == null) {
                    System.out.printf("%10s", 'X');
                    continue;
                }
                System.out.printf("%10s ", figure);
            }
            System.out.print("\n");
        }
    }
}
