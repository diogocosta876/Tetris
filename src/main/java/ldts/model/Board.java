package ldts.model;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import ldts.model.MatrixOperations.RotateMatrix;


public class Board implements BoardInterface{
    private String[][] matrix;
    private int width;
    private int length;

    public Board(int width, int length){
        width = width/2;
        this.width = width;
        this.length = length;

        matrix = new String[length][width];

        for (int y = 0; y < length; y++){
            for (int x = 0; x < width; x++){
                matrix[y][x] = "#000000";
            }
        }
        System.out.println("element added");
    }

    public boolean canMove(int nextPosX, Piece piece) {
        for (int y = 0; y < piece.getMatrix().length; y++) {
            for (int x = 0; x < piece.getMatrix()[y].length; x++) {
                if (piece.getMatrix()[y][x] != "#000000") {
                    if (!matrix[piece.getPos_y()+y][x + nextPosX].equals("#000000")) {
                        System.out.println("Can't move there");
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public boolean canRotate(Piece piece){
        String[][] tempMatrix = piece.getMatrix().clone();
        tempMatrix = RotateMatrix.execute(tempMatrix);

        for (int y = 0; y < tempMatrix.length; y++) {
            for (int x = 0; x < tempMatrix[y].length; x++) {
                if (tempMatrix[y][x] != "#000000") {
                    try{
                        if (!matrix[piece.getPos_y()+y][piece.getPos_x() + x].equals("#000000")) {
                            System.out.println("Can't rotate there");
                            return false;
                        }
                    }catch(Exception e){
                        return false;
                    }
                }
            }
        }
        return true;


    }

    public boolean hasHitBottom(Piece piece){
        for(int y =0; y<piece.getMatrix().length; y++){
            for (int x = 0; x <piece.getMatrix()[y].length; x++){
                if(piece.getMatrix()[y][x]!="#000000") {
                    if(y+piece.getPos_y()+1 == matrix.length){
                        System.out.println("Chegou ao Fundo");
                        addPiece(piece);
                        return true;
                    }
                    else if(matrix[y+piece.getPos_y()+1][x+ piece.getPos_x()]!="#000000"){
                        System.out.println("Colisão com peça");
                        addPiece(piece);
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public void addPiece(Piece piece){
        for(int y =0; y<piece.getMatrix().length;y++){
            for(int x=0; x<piece.getMatrix()[y].length;x++){
                if(piece.getMatrix()[y][x] != "#000000"){
                    matrix[y+piece.getPos_y()][x+ piece.getPos_x()] = piece.getMatrix()[y][x];
                }
            }
        }

    }

    public int checkLineCompletition(RemoveLine remover){
        int counter = 0;
        for (int y = 0; y < length; y++){
            boolean fullprintedline = true;
            for (int x = 0; x < width; x++){
                if(matrix[y][x] == "#000000"){
                    fullprintedline = false;
                    break;
                }
            }
            if(fullprintedline) {
                counter++;
                matrix = remover.removeLine(y, this.matrix);
                y--;
            }
        }

        return counter;
    }

    public String[][] getMatrix() {
        return matrix;
    }

    public int getWidth() {
        return width;
    }

    public int getLength() {
        return length;
    }

    public void setMatrix(String[][] matrix){
        this.matrix = matrix;
    }

    public boolean gameOver(){
        for (int x = 0; x < width; x++){
            if(matrix[0][x] != "#000000"){
                return true;
            }
        }
        return false;
    }

}
