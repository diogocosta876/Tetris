package ldts.model.PieceStates;

import ldts.model.MatrixOperations.IntMatrixToString;
import ldts.model.Piece;

public class SPiece implements PieceState {
    String color = "#00F000";
    int[][] matrix = new int[][]{
            {0,1,1},
            {1,1,0}};

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public String[][] getMatrix() {
        return IntMatrixToString.convert(matrix, color);
    }
}
