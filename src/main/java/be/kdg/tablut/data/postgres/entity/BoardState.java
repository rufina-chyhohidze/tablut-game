package be.kdg.tablut.data.postgres.entity;

import be.kdg.tablut.domain.board.Board;

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
        // TODO: implement me
        return null;
    }
}
