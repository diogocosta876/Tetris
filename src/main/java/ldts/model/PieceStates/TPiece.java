package ldts.model.PieceStates;

import ldts.model.MatrixOperations.IntMatrixToString;
import ldts.model.Piece;

public class TPiece implements PieceState {
    String color = "#A000F0";
    int[][] matrix = new int[][]{
            {0,1,0},
            {1,1,1}};

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public String[][] getMatrix() {
        return IntMatrixToString.convert(matrix, color);
    }
}
