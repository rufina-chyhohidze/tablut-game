package be.kdg.tablut.data.postgres.entity;

import be.kdg.tablut.domain.board.Board;

public class BoardState {

    private int id;
    private BoardFigure[] figures;

    public int getId() {
        return id;
    }

    private void setId(int id) {
        this.id = id;
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
