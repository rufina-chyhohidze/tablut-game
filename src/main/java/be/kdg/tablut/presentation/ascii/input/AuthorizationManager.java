package be.kdg.tablut.presentation.ascii.input;

import be.kdg.tablut.domain.game.MoveTurn;
import be.kdg.tablut.domain.player.Player;

import java.util.Scanner;

public class AuthorizationManager {

    private static void printIntroMessage() {
        System.out.println("""
                                _       _   _            _         _   _         \s
                               /_\\ _  _| |_| |_  ___ _ _(_)_____ _| |_(_)___ _ _ \s
                              / _ \\ || |  _| ' \\/ _ \\ '_| |_ / _` |  _| / _ \\ ' \\\s
                             /_/ \\_\\_,_|\\__|_||_\\___/_| |_/__\\__,_|\\__|_\\___/_||_|
                                                                                 \s
                """);
    }

    public static Player authorizeWhitePlayer() {
        printIntroMessage();
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Enter White Player username: ");
        String username = keyboard.nextLine();

        return new Player(username, MoveTurn.WHITE);
    }

    public static Player authorizeBlackPlayer() {
        printIntroMessage();
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Enter Black Player username: ");
        String username = keyboard.nextLine();

        return new Player(username, MoveTurn.BLACK);
    }
}
