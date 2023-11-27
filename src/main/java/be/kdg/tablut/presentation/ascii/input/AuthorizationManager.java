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

    public static Player authorizePlayer() {
        printIntroMessage();
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Enter username: ");
        String username = keyboard.nextLine();

        return new Player(username, MoveTurn.WHITE);
    }
}
