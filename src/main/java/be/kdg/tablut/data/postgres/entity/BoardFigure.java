package be.kdg.tablut.data.postgres.entity;

public class BoardFigure {

    private final int rowNumber;
    private final int colNumber;
    private final String figure;

    public BoardFigure(int rowNumber, int colNumber, String figure) {
        this.rowNumber = rowNumber;
        this.colNumber = colNumber;
        this.figure = figure;
    }

    public int getColNumber() {
        return colNumber;
    }

    public int getRowNumber() {
        return rowNumber;
    }

    public String getFigure() {
        return figure;
    }
}
