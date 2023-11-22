package be.kdg.tablut.domain.figure;

import be.kdg.tablut.domain.grid.GridPosition;

public class Mercenary extends Figure {

    public Mercenary() {
        type = FigureType.MERCENARY;
    }

    @Override
    public String toString() {
        return "M";
    }
}
