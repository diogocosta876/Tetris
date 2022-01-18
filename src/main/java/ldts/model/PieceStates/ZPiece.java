package ldts.model.PieceStates;

import ldts.model.MatrixOperations.IntMatrixToString;
import ldts.model.Piece;

public class ZPiece extends PieceState {
    public ZPiece(){
        color = "#F10000";
        matrix = new int[][]{
                {1,1,0},
                {0,1,1}};
    }

}
