package be.kdg.tablut.presentation.ascii.output;

import be.kdg.tablut.domain.Constants;
import be.kdg.tablut.presentation.ascii.AsciiConstants;
import be.kdg.tablut.domain.board.Board;
import be.kdg.tablut.domain.figure.Figure;

public class BoardDisplayManager {

    private static void printColumns() {
        for (int i = 0; i < Constants.gridSize; i++) {
            System.out.printf(
                    "%10s  ",
                    AsciiConstants.getColumnLabels().get(i % AsciiConstants.getColumnLabels().size())
            );
        }
        System.out.print("\n");
    }

    public static void printGameBoard(Board gameBoard) {
        System.out.println("\n".repeat(2));

        printColumns();
        int rowNumber = 1;
        for (Figure[] row : gameBoard.getSlots()) {

            System.out.println(" ".repeat(5) + "-".repeat(Constants.gridSize * 12));

            System.out.printf("%3d  |", rowNumber);
            for (Figure figure : row) {
                if (figure == null) {
                    System.out.printf("%10s |", ' ');
                    continue;
                }

                System.out.printf("%10s |", figure);
            }

            rowNumber++;
            System.out.print("\n");
        }
        System.out.println(" ".repeat(5) + "-".repeat(Constants.gridSize * 12));
        System.out.println("\n".repeat(2));
    }

}
