package be.kdg.tablut.domain.grid;

public class GridPosition {
    public int row;
    public int col;
    private final boolean isCenter;

    public boolean isThrone() {
        return isCenter;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj.getClass() != this.getClass()) {
            return false;
        }

        final GridPosition toCompare = (GridPosition) obj;
        return (this.row == toCompare.row && this.col == toCompare.col);
    }

    public GridPosition(int row, int col) throws IllegalArgumentException
    {
        if ( (row < 0 || row >= 9) || (col < 0 || col >= 9))
        {
            throw new IllegalArgumentException("invalid grid position");
        }
        this.row = row;
        this.col = col;
        this.isCenter = (this.row == 4 && this.col == 4);
    }


}
