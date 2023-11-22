package be.kdg.tablut.domain.figure;

public class King extends Figure{

    public King() {
        type = FigureType.KING;
    }

    @Override
    public String toString() {
        return "K";
    }

}
