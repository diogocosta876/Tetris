public class LinePiece extends Piece{
    public LinePiece(){
        super();
        color = "#00F0F0";

        int[][] matrixInt = new int[][]{
                {1,1,1,1}};

        this.matrix = convertIntMatrixToStringMatrix(matrixInt);
    }
}
