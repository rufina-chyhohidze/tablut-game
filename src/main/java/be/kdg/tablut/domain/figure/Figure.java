package be.kdg.tablut.domain.figure;

public class Figure {
    private FigureType type;

    public Figure(FigureType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        switch (type) {
            case KING -> {
                return "KING";
            }
            case MERCENARY -> {
                return "MERCENARY";
            }

            case GUARD -> {
                return "GUARD";
            }

            default -> {
                return "";
            }
        }
    }

    public FigureType getType() {
        return type;
    }

}
