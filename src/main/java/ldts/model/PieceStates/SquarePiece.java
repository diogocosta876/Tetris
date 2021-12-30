package ldts.model.PieceStates;

import ldts.model.MatrixOperations.IntMatrixToString;
import ldts.model.Piece;

public class SquarePiece implements PieceState {
    String color = "#0033CC";
    int[][] matrix = new int[][]{
            {1,1},
            {1,1}};

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public String[][] getMatrix() {
        return IntMatrixToString.convert(matrix, color);
    }
}
