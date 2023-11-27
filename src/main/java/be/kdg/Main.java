package be.kdg;

import be.kdg.tablut.domain.player.Player;
import be.kdg.tablut.presentation.ascii.Tablut;
import be.kdg.tablut.presentation.ascii.input.AuthorizationManager;

public class Main {
    public static void main(String[] args) {
        Player playerWhite = AuthorizationManager.authorizeWhitePlayer();
        Player playerBlack = AuthorizationManager.authorizeBlackPlayer();

        Tablut tablut = new Tablut(playerWhite, playerBlack);

        tablut.start();
    }
}
