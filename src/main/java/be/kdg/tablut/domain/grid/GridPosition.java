package be.kdg.tablut.domain.grid;

public class GridPosition {
    public int row;
    public int col;

    public GridPosition(int row, int col) throws IllegalArgumentException
    {
        if ( (row < 0 || row >= 9) || (col < 0 || col >= 9))
        {
            throw new IllegalArgumentException("invalid grid position");
        }
        this.row = row;
        this.col = col;
    }
}
