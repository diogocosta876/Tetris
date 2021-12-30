package ldts.model.PieceStates;

import ldts.model.MatrixOperations.IntMatrixToString;

public class LPiece implements PieceState {
    String color = "#F0A000";
    int[][] matrix = new int[][]{ {1,0},
            {1,0},
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
