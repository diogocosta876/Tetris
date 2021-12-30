package ldts.model.PieceStates;

import ldts.model.MatrixOperations.IntMatrixToString;
import ldts.model.Piece;

public class ZPiece implements PieceState {
    String color = "#F10000";
    int[][] matrix = new int[][]{
            {1,1,0},
            {0,1,1}};

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public String[][] getMatrix() {
        return IntMatrixToString.convert(matrix, color);
    }
}
