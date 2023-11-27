package be.kdg;

import be.kdg.tablut.domain.player.Player;
import be.kdg.tablut.presentation.ascii.Tablut;
import be.kdg.tablut.presentation.ascii.input.AuthorizationManager;

public class Main {
    public static void main(String[] args) {
        Player player = AuthorizationManager.authorizePlayer();

        Tablut tablut = new Tablut(player);

        tablut.start();
    }
}
