package be.kdg.tablut.domain.board;

import be.kdg.tablut.domain.Constants;

public class BoardPosition {
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

        final BoardPosition toCompare = (BoardPosition) obj;
        return (this.row == toCompare.row && this.col == toCompare.col);
    }

    public BoardPosition(int row, int col) throws IllegalArgumentException
    {
        if ( (row < 0 || row >= Constants.gridSize) || (col < 0 || col >= Constants.gridSize))
        {
            throw new IllegalArgumentException("invalid grid position");
        }
        this.row = row;
        this.col = col;
        this.isCenter = (this.row == Constants.gridSize / 2 && this.col == Constants.gridSize / 2);
    }


}
