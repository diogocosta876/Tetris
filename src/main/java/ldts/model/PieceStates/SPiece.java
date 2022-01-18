package ldts.model.PieceStates;

import ldts.model.MatrixOperations.IntMatrixToString;
import ldts.model.Piece;

public class SPiece extends PieceState {
    public SPiece(){
        color = "#00F000";
        matrix = new int[][]{
                {0,1,1},
                {1,1,0}};
    }

}
