package ldts.model.pieces;

import ldts.model.Piece;

public class ZPiece extends Piece {
    public ZPiece(){
        super();
        color = "#F10000";

        int[][] matrixInt = new int[][]{
                {1,1,0},
                {0,1,1}};

        this.matrix = convertIntMatrixToStringMatrix(matrixInt);
    }
}
