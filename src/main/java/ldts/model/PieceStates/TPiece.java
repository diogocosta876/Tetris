package ldts.model.PieceStates;

import ldts.model.MatrixOperations.IntMatrixToString;
import ldts.model.Piece;

public class TPiece extends PieceState {
    public TPiece(){
        color = "#A000F0";
        matrix = new int[][]{
                {0,1,0},
                {1,1,1}};
    }

}
