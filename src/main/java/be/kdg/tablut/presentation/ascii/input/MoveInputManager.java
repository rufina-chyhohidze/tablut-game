package be.kdg.tablut.presentation.ascii.input;

import be.kdg.tablut.domain.board.BoardPosition;

import java.util.Scanner;

public class MoveInputManager {

    public static BoardPosition takeMoveInput() {
        Scanner keyboard = new Scanner(System.in);
        BoardPosition moveInput;
        int row;
        int col;

        while (true) {
            try{
                System.out.print("Enter row(1-9): ");
                row = keyboard.nextInt();

                System.out.print("Enter column(1-9): ");
                col = keyboard.nextInt();

                moveInput = new BoardPosition(row - 1, col - 1);
                return moveInput;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
