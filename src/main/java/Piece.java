import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;

import javax.sql.rowset.spi.SyncResolver;
import java.util.ArrayList;
import java.util.List;

public class Piece {
    private String[][] matrix;
    private int pos_x = Game.getGameScreenWidth()/2-1;
    private int pos_y =0;
    private String color = "#0033CC";

    public Piece(){
        int[][] matrixInt = new int[][]{
                //Must be a square
                {1,1},
                {1,1}};

        this.matrix = convertIntMatrixToStringMatrix(matrixInt);
    }

    public String[][] convertIntMatrixToStringMatrix(int[][] matrix){
        String[][] pieceMatrix = new String[matrix.length][matrix[0].length];

        for (int y = 0; y < matrix.length; y++){
            for (int x = 0; x < matrix[y].length; x++){
                if(matrix[y][x]==1) {
                    pieceMatrix[y][x] = color;
                }else{
                    pieceMatrix[y][x] = "#000000";
                }

            }
        }
        return pieceMatrix;
    }

    public void draw(TextGraphics screen){
        screen.setBackgroundColor(TextColor.Factory.fromString(color));

        for(int y =0; y<matrix.length; y++){
            for (int x = 0; x < matrix[y].length; x++){
                if(matrix[y][x]!="#000000") {
                    screen.putString(new TerminalPosition(pos_x + x + Game.getGameScreenXoffset(), pos_y + y + Game.getGameScreenYoffset()), " ");
                }
            }
        }


    }
    public void moveLeft(){ pos_x-=2; }
    public void moveRight(){ pos_x+=2; }
    public void forceDown(){ pos_y++; }

    public int getBottomPos(){
        return pos_y + getMatrix().length -1;
    }
    public int getRightPos(){
        return pos_x + getMatrix()[0].length -1;
    }



    public int getPos_x() {
        return pos_x;
    }

    public int getPos_y() {
        return pos_y;
    }

    public String[][] getMatrix() {
        return matrix;
    }
}