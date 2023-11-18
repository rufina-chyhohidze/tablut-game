package be.kdg.tablut.domain.figure;

public class FigureFactory {

    public static Figure CreateKing() {
        return new Figure(FigureType.KING);
    }

    public static Figure CreateGuard() {
        return new Figure(FigureType.GUARD);
    }

    public static Figure CreateMercenary() {
        return new Figure(FigureType.MERCENARY);
    }

}
