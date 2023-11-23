package be.kdg.tablut.domain.figure;

public class Mercenary extends Figure {

    public Mercenary() {
        type = FigureType.MERCENARY;
        isWhite = false;
        canAttack = true;
    }

    @Override
    public String toString() {
        return "M";
    }
}
