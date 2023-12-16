package be.kdg.tablut.data.postgres.entity;

import be.kdg.tablut.domain.Constants;
import be.kdg.tablut.domain.board.Board;
import be.kdg.tablut.domain.board.BoardFactory;
import be.kdg.tablut.domain.board.BoardPosition;
import be.kdg.tablut.domain.figure.Figure;

public class BoardState {

    private BoardFigure[] figures;

    public BoardState(BoardFigure[] figures) {
        setFigures(figures);
    }

    public BoardFigure[] getFigures() {
        return figures;
    }

    private void setFigures(BoardFigure[] figures) {
        this.figures = figures;
    }

    public Board toBoard() {
        Figure[][] slots = new Figure[Constants.gridSize][Constants.gridSize];

        for (BoardFigure figure: figures) {
            slots[figure.getRowNumber()][figure.getColNumber()] = figure.toFigure();
        }

        return BoardFactory.createBoard(slots);
    }
}
