package be.kdg.tablut.presentation.ascii.output;

import be.kdg.tablut.domain.Constants;
import be.kdg.tablut.domain.board.Board;
import be.kdg.tablut.domain.figure.Figure;

import java.util.ArrayList;

public class BoardDisplayManager {

    private static void printColumns() {

        for (int i = 0; i < Constants.gridSize; i++) {
            System.out.printf("%10s |", "");
        }
    }

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
