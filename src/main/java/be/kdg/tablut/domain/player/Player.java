package be.kdg.tablut.domain.player;

import be.kdg.tablut.domain.game.MoveTurn;

public class Player {
    private final String username;

    public String getUsername() {
        return username;
    }

    private final MoveTurn color;

    public MoveTurn getColor() {
        return color;
    }

    public Player(String username, MoveTurn color) {
        this.username = username;
        this.color = color;
    }
}
