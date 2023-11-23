package be.kdg.tablut.domain.figure;

public class Mercenary extends Figure {

    public Mercenary() {
        type = FigureType.MERCENARY;
        isWhite = false;
    }

    @Override
    public String toString() {
        return "M";
    }
}
