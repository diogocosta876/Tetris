package ldts.model.pieces;

import ldts.model.Piece;

public class JPiece extends Piece {
    public JPiece(){
        super();
        color = "#F0F001";

        int[][] matrixInt = new int[][]{
                {0,1},
                {0,1},
                {1,1}};

        this.matrix = convertIntMatrixToStringMatrix(matrixInt);
    }
}
