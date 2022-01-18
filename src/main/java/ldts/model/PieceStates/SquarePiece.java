package ldts.model.PieceStates;

import ldts.model.MatrixOperations.IntMatrixToString;
import ldts.model.Piece;

public class SquarePiece extends PieceState {
    public SquarePiece(){
         color = "#0033CC";
         matrix = new int[][]{
                {1,1},
                {1,1}};
    }

}
