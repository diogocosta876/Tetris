package ldts.model.pieces;

import ldts.model.Piece;

public class SquarePiece extends Piece {

    public SquarePiece(){
        super();
        color = "#0033CC";

        int[][] matrixInt = new int[][]{
                //Must be a square
                {1,1},
                {1,1}};

        this.matrix = convertIntMatrixToStringMatrix(matrixInt);
    }

}
