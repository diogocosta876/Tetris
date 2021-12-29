import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;

import javax.sql.rowset.spi.SyncResolver;
import java.util.ArrayList;
import java.util.List;

public abstract class Piece {
    protected String[][] matrix;
    protected int pos_x;
    protected int pos_y;
    protected String color;

    public Piece(){
        pos_x = Game.getGameScreenWidth()/2;
        pos_y = 0;
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

        for(int y =0; y< matrix.length; y++){
            for (int x = 0; x < matrix[y].length*2; x+=2){
                if(matrix[y][x/2]!="#000000") {
                    //TODO REMOVE LINE (on to debug)
                    screen.putString(new TerminalPosition(pos_x*2 + x + Game.getGameScreenXoffset(), pos_y + y + Game.getGameScreenYoffset()), Integer.toString(pos_x + x/2));
                    //screen.putString(new TerminalPosition(pos_x*2 + x + Game.getGameScreenXoffset(), pos_y + y + Game.getGameScreenYoffset()), " ");
                    screen.putString(new TerminalPosition(pos_x*2 + x +1 + Game.getGameScreenXoffset(), pos_y + y + Game.getGameScreenYoffset()), " ");
                }
            }
        }
    }
    public void moveLeft(){ pos_x-=1; }
    public void moveRight(){ pos_x+=1; }
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
