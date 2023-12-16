package be.kdg.tablut.data.postgres.mapper;

import be.kdg.tablut.data.postgres.entity.BoardFigure;
import be.kdg.tablut.data.postgres.entity.BoardState;
import be.kdg.tablut.domain.Constants;
import be.kdg.tablut.domain.board.BoardPosition;
import be.kdg.tablut.domain.figure.Figure;
import be.kdg.tablut.domain.game.Game;

import java.util.ArrayList;

public class BoardStateMapper {

    public static BoardState getBoardStateFromGame(Game game) {

        Figure[][] boardSlots = game.getBoard().getSlots();
        ArrayList<BoardFigure> figuresToStore = new ArrayList<>();

        for (int row = 0; row < Constants.gridSize; row++) {
            for (int col = 0; col < Constants.gridSize; col++) {
                BoardPosition boardPosition = new BoardPosition(row, col);
                Figure figure = boardSlots[row][col];

                if (figure == null) {
                    continue;
                }

                BoardFigure figureToStore = getFigureValueToStore(figure, boardPosition);
                figuresToStore.add(figureToStore);
            }
        }

        return new BoardState(figuresToStore.toArray(new BoardFigure[0]));
    }

    public static BoardFigure getFigureValueToStore(Figure figure, BoardPosition position) {
        return new BoardFigure(
                position.row,
                position.col,
                figure.toString()
        );
    }
}
