package be.kdg.tablut.presentation.ascii.input;

import be.kdg.tablut.domain.Constants;
import be.kdg.tablut.domain.board.BoardPosition;
import be.kdg.tablut.presentation.ascii.AsciiConstants;

import java.util.*;

public class MoveInputManager {

    public static BoardPosition takePositionInput() {
        Scanner keyboard = new Scanner(System.in);
        while (true) {
            try{
                int col = takeColumnInput();
                int row = takeRowInput();
                return new BoardPosition(row , col);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static int takeColumnInput() {
        Scanner keyboard = new Scanner(System.in);
        String columnInput;

        while(true) {
            try {
                System.out.printf(
                        "Enter Column (%s - %s): ",
                        AsciiConstants.getColumnLabels().get(0),
                        AsciiConstants.getColumnLabels().get(Constants.gridSize - 1)
                );

                columnInput = keyboard.next().toUpperCase();

                if (!AsciiConstants.getColumnLabels().contains(columnInput))
                {
                    continue;
                }

                return AsciiConstants.getColumnLabels().indexOf(columnInput);

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static int takeRowInput() {
        Scanner keyboard = new Scanner(System.in);
        int rowInput;
        while(true) {
            try {
                System.out.printf("Enter row( 1 - %s ): ",  Constants.gridSize);
                rowInput = keyboard.nextInt();

                if (rowInput > Constants.gridSize || rowInput < 0)
                {
                    continue;
                }

                return rowInput - 1;

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
