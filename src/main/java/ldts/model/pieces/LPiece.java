package ldts.model.pieces;

import ldts.model.Piece;

public class LPiece extends Piece {
    public LPiece(){
        super();
        color = "#F0A000";

        int[][] matrixInt = new int[][]{
                {1,0},
                {1,0},
                {1,1}};

        this.matrix = convertIntMatrixToStringMatrix(matrixInt);
    }
}
