public class TPiece extends Piece{
    public TPiece(){
        super();
        color = "#A000F0";

        int[][] matrixInt = new int[][]{
                {0,1,0},
                {1,1,1}};

        this.matrix = convertIntMatrixToStringMatrix(matrixInt);
    }
}
