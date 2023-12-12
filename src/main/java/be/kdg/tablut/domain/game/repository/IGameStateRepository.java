package be.kdg.tablut.domain.game.repository;

import be.kdg.tablut.domain.game.GameState;
import be.kdg.tablut.domain.player.Player;

import java.util.Optional;

public interface IGameStateRepository {

    Optional<GameState> getGameStateByPlayers(Player playerWhite, Player playerBlack);

}
