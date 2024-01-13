package be.kdg.tablut.domain.figure;

import be.kdg.tablut.domain.Constants;
import be.kdg.tablut.domain.board.BoardPosition;

import java.util.ArrayList;

public abstract class Figure {
    protected FigureType type;
    public boolean isWhite;

    public boolean canAttack;

    public FigureType getType() {
        return type;
    }

    public ArrayList<BoardPosition> getPossibleMoves(BoardPosition currentPosition) {
        ArrayList<BoardPosition> possibleMoves = new ArrayList<BoardPosition>();

        // Horizontal
        for (int col = 0; col < Constants.gridSize; col++) {
            if (col == currentPosition.col) {
                continue;
            }
            possibleMoves.add(new BoardPosition(currentPosition.row, col));
        }

        // Vertical
        for (int row = 0; row < Constants.gridSize; row++) {
            if (row == currentPosition.row) {
                continue;
            }
            possibleMoves.add(new BoardPosition(row, currentPosition.col));
        }

        return possibleMoves;
    }
}
