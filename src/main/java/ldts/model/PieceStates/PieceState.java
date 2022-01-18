package ldts.model.PieceStates;

import ldts.model.MatrixOperations.IntMatrixToString;

public abstract class PieceState {
    protected String color;
    protected int[][] matrix;


    public String getColor(){
        return color;
    }

    public String[][] getMatrix() {
        if(matrix != null){
            return IntMatrixToString.convert(matrix, color);
        }
        return null;
    }

}
