package be.kdg.tablut.presentation.ascii.input;

import be.kdg.tablut.presentation.ascii.AsciiConstants;

import java.util.Scanner;

public class CommandInputManager {
    public static AsciiConstants.CommandType takeCommandInput() {
        Scanner keyboard = new Scanner(System.in);


        while (true) {
            System.out.print("Enter Command: ");
            String playerInput = keyboard.nextLine().toUpperCase();

            if (playerInput.equals("S")) {
                return AsciiConstants.CommandType.START;
            }

            if (playerInput.equals("R")) {
                return AsciiConstants.CommandType.RULES;
            }

            if (playerInput.equals("C")) {
                return AsciiConstants.CommandType.COMMANDS;
            }

            if (playerInput.equals("L")) {
                return AsciiConstants.CommandType.LEADERBOARD;
            }
        }

    }
}
