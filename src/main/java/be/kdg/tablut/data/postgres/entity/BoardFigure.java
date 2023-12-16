package be.kdg.tablut.data.postgres.entity;

import be.kdg.tablut.domain.figure.Figure;
import be.kdg.tablut.domain.figure.Guard;
import be.kdg.tablut.domain.figure.King;
import be.kdg.tablut.domain.figure.Mercenary;

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

    public Figure toFigure() {
        // FIXME: hardcoded constants
        switch (figure) {
            case "k" -> {
                return new King();
            }
            case "g" -> {
                return new Guard();
            }
            case "m" -> {
                return new Mercenary();
            }
            default -> {
                return null;
            }
        }
    }


}
