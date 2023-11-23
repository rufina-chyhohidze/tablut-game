package be.kdg.tablut.domain.figure;

public class Guard extends Figure{
    public Guard() {
        type = FigureType.GUARD;
        isWhite = true;
        canAttack = true;
    }

    @Override
    public String toString() {
        return "G";
    }
}
