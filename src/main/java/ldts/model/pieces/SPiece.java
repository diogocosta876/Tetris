package ldts.model.pieces;

import ldts.model.Piece;

public class SPiece extends Piece {
    public SPiece(){
        super();
        color = "#00F000";

        int[][] matrixInt = new int[][]{
                {0,1,1},
                {1,1,0}};

        this.matrix = convertIntMatrixToStringMatrix(matrixInt);
    }
}
