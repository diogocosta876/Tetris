package ldts.model.PieceStates;

import ldts.model.MatrixOperations.IntMatrixToString;

public class LinePiece implements PieceState {
    String color = "#00F0F0";
    int[][] matrix = new int[][]{ {1,1,1,1}};

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public String[][] getMatrix() {
        return IntMatrixToString.convert(matrix, color);
    }
}
