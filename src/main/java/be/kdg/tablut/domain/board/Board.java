package be.kdg.tablut.domain.board;

import be.kdg.tablut.domain.Constants;
import be.kdg.tablut.domain.figure.Figure;
import be.kdg.tablut.domain.figure.FigureType;

import java.util.ArrayList;

public class Board {
    private final Figure[][] slots;

    public Figure[][] getSlots() {
        return slots;
    }

    Board(Figure[][] slots) {
        this.slots = slots;
    }

    public boolean isSlotTaken(BoardPosition position) {
        return slots[position.row][position.col] != null;
    }

    public BoardPosition GetKingPosition() {
        for (int row = 0; row < Constants.gridSize; row++) {
            for (int col = 0; col < Constants.gridSize; col++) {
                Figure figure = slots[row][col];
                if (figure != null && figure.getType() == FigureType.KING) {
                    return new BoardPosition(row, col);
                }
            }
        }
        return null;
    }

    public static ArrayList<BoardPosition> getPositionNeighbors(BoardPosition currentPosition) {
        ArrayList<BoardPosition> allNeighbors = new ArrayList<BoardPosition>();

        ArrayList<BoardPosition> horizontalNeighbors = getHorizontalNeighbors(currentPosition);
        ArrayList<BoardPosition> verticalNeighbors = getVerticalNeighbors(currentPosition);

        allNeighbors.addAll(horizontalNeighbors);
        allNeighbors.addAll(verticalNeighbors);

        return allNeighbors;
    }

    public static ArrayList<BoardPosition> GetBorderPositions() {
        ArrayList<BoardPosition> borderPositions = new ArrayList<>();

        for (int col = 0; col < Constants.gridSize; col++) {
            borderPositions.add(new BoardPosition(0, col));
            borderPositions.add(new BoardPosition(Constants.gridSize - 1, col));
        }

        for (int row = 0; row < Constants.gridSize; row++) {
            borderPositions.add(new BoardPosition(row, 0));
            borderPositions.add(new BoardPosition(row, Constants.gridSize - 1));
        }


        return borderPositions;
    }

    public boolean canMoveTo(BoardPosition currentPosition, BoardPosition targetPosition) {

        if (isSlotTaken(targetPosition) || targetPosition.isThrone()) {
            return false;
        }

        Figure figureToMove = slots[currentPosition.row][currentPosition.col];
        if (figureToMove == null) {
            return false;
        }

        ArrayList<BoardPosition> possibleMoves = figureToMove.getPossibleMoves(currentPosition);

        if (!possibleMoves.contains(targetPosition)) {
            return false;
        }

        ArrayList<BoardPosition> positionsBetween = getPositionsBetweenPositions(currentPosition, targetPosition);
        for (BoardPosition positionBetween: positionsBetween) {
            if (isSlotTaken(positionBetween)) {
                return false;
            }
        }

        return true;
    }

    public void moveFigure(BoardPosition currentPosition, BoardPosition targetPosition) throws IllegalArgumentException {
        Figure figureToMove = slots[currentPosition.row][currentPosition.col];

        slots[currentPosition.row][currentPosition.col] = null;
        slots[targetPosition.row][targetPosition.col] = figureToMove;

        updateBoardCheckAttacks();
    }

    public int getFiguresCountByColor(boolean isWhite) {
        int count = 0;

        for (int row = 0; row < Constants.gridSize; row++) {
            for (Figure figure : slots[row]) {
                if (figure == null) {
                    continue;
                }

                if (figure.isWhite == isWhite) {
                    count++;
                }

            }
        }

        return count;
    }

    private void removeFigure(BoardPosition position) {
        slots[position.row][position.col] = null;
    }

    private ArrayList<BoardPosition> getPositionsBetweenPositions(
            BoardPosition currentPosition,
            BoardPosition targetPosition
    ) {
        ArrayList<BoardPosition> positionsBetween = new ArrayList<>();

        if (
                (currentPosition.row != targetPosition.row) &&
                (currentPosition.col != targetPosition.col)
        ) {
            return positionsBetween;
        }

        // Row
        if (currentPosition.row == targetPosition.row) {
            for (
                    int col = Math.min(currentPosition.col, targetPosition.col);
                    col < Math.max(currentPosition.col, targetPosition.col);
                    col++
            ){
                positionsBetween.add(new BoardPosition(currentPosition.row, col));
            }
            return positionsBetween;
        }

        // Col
        for (
                int row = Math.min(currentPosition.row, targetPosition.row);
                row < Math.max(currentPosition.row, targetPosition.row);
                row++
        ) {
            positionsBetween.add(new BoardPosition(row, currentPosition.col));
        }


        return positionsBetween;
    }

    private void updateBoardCheckAttacks() {
        for (int row = 0; row < Constants.gridSize; row++) {
            for (int col = 0; col < Constants.gridSize; col++) {
                BoardPosition currentPosition = new BoardPosition(row, col);

                boolean  isHorizontalAttacked  = checkHorizontalAttack(currentPosition);
                boolean isVerticallyAttacked = checkVerticalAttack(currentPosition);

                if (isHorizontalAttacked || isVerticallyAttacked) {
                    removeFigure(currentPosition);
                }
            }
        }
    }

    private static ArrayList<BoardPosition> getHorizontalNeighbors(BoardPosition currentPosition) {
        ArrayList<BoardPosition> neighbors = new ArrayList<>();

        // Left
        if (currentPosition.col != 0) {
            neighbors.add(new BoardPosition(currentPosition.row, currentPosition.col - 1));
        }

        // Right
        if (currentPosition.col != Constants.gridSize - 1) {
            neighbors.add(new BoardPosition(currentPosition.row, currentPosition.col + 1));
        }

        return neighbors;
    }

    private static ArrayList<BoardPosition> getVerticalNeighbors(BoardPosition currentPosition) {
        ArrayList<BoardPosition> neighbors = new ArrayList<>();

        // Top
        if (currentPosition.row != 0) {
            neighbors.add(new BoardPosition(currentPosition.row -1, currentPosition.col));
        }

        // Bottom
        if (currentPosition.row != Constants.gridSize - 1) {
            neighbors.add(new BoardPosition(currentPosition.row +1, currentPosition.col));
        }

        return neighbors;
    }

    private boolean checkHorizontalAttack(BoardPosition position) {
        ArrayList<BoardPosition> horizontalNeighbors = getHorizontalNeighbors(position);
        if (horizontalNeighbors.size() != 2) {
            return false;
        }

        Figure neighbor1 = slots[horizontalNeighbors.get(0).row][horizontalNeighbors.get(0).col];
        Figure figureToCheckAttack = slots[position.row][position.col];
        Figure neighbor2 = slots[horizontalNeighbors.get(1).row][horizontalNeighbors.get(1).col];

        if (neighbor1 == null || neighbor2 == null || figureToCheckAttack == null) {
            return false;
        }

        return (
                (neighbor1.isWhite == neighbor2.isWhite) &&
                (neighbor1.canAttack && neighbor2.canAttack) &&
                (neighbor1.isWhite != figureToCheckAttack.isWhite)
        );

    }

    private boolean checkVerticalAttack(BoardPosition position) {
        ArrayList<BoardPosition> verticalNeighbors = getVerticalNeighbors(position);
        if (verticalNeighbors.size() != 2) {
            return false;
        }

        Figure neighbor1 = slots[verticalNeighbors.get(0).row][verticalNeighbors.get(0).col];
        Figure figureToCheckAttack = slots[position.row][position.col];
        Figure neighbor2 = slots[verticalNeighbors.get(1).row][verticalNeighbors.get(1).col];

        if (neighbor1 == null || neighbor2 == null || figureToCheckAttack == null) {
            return false;
        }

        return (
                (neighbor1.isWhite == neighbor2.isWhite) &&
                (neighbor1.canAttack && neighbor2.canAttack) &&
                (neighbor1.isWhite != figureToCheckAttack.isWhite)
        );
    }

}
