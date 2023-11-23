package be.kdg.tablut.presentation.ascii;

import be.kdg.tablut.domain.Constants;
import be.kdg.tablut.domain.board.Board;
import be.kdg.tablut.domain.figure.Figure;

public class BoardDisplayManager {

    public static void printGameBoard(Board gameBoard) {
        for (Figure[] row : gameBoard.getSlots()) {

            System.out.println("-".repeat(Constants.gridSize * 12));

            for (Figure figure : row) {

                if (figure == null) {
                    System.out.printf("%10s |", ' ');
                    continue;
                }

                System.out.printf("%10s |", figure);
            }

            System.out.print("\n");
        }
        System.out.println("-".repeat(Constants.gridSize * 12));
    }

}
