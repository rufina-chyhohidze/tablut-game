package be.kdg;

import be.kdg.tablut.domain.board.GameBoard;
import be.kdg.tablut.domain.figure.Figure;

public class Main {
    public static void main(String[] args) {

        GameBoard gameBoard = new GameBoard();

        // TODO: move all printing to presentation layer
        // TODO: center value within cell
        for (Figure[] row : gameBoard.getGrid().getSlots())
        {
            System.out.println("-".repeat(108));
            for (Figure figure : row)
            {
                if (figure == null) {
                    System.out.printf("%10s |", ' ');
                    continue;
                }
                System.out.printf("%10s |", figure);
            }
            System.out.print("\n");
        }

        System.out.println("-".repeat(108));
    }
}
