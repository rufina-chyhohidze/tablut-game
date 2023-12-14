package be.kdg.tablut.presentation.ascii.input;

import be.kdg.tablut.presentation.ascii.AsciiConstants;

import java.util.Scanner;

public class EndGameCommandInputManager {
    public static AsciiConstants.EndGameCommand takeEndGameCommandInput() {
        Scanner keyboard = new Scanner(System.in);

        while (true) {
            System.out.print("Enter Command: ");
            String playerInput = keyboard.nextLine().toUpperCase();

            if (playerInput.equals("R")) {
                return AsciiConstants.EndGameCommand.RESTART;
            }

            if (playerInput.equals("Q")) {
                return AsciiConstants.EndGameCommand.QUIT;
            }
        }

    }
}
