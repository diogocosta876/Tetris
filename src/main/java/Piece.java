import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;

import javax.sql.rowset.spi.SyncResolver;
import java.util.ArrayList;
import java.util.List;

public class Piece {
    List<Point> matrix;
    int pos_x = Game.getGameScreenWidth()/2-1;
    int pos_y =0;
    private String color = "#0033CC";

    public Piece(){
        int[][] matrixInt = new int[][]{
                {1,1},
                {1,1}};

        this.matrix = convertMatrixToPointList(matrixInt);
    }

    public List<Point> convertMatrixToPointList(int[][] matrix){
        List<Point> pieceMatrix = new ArrayList<>();
        for (int y = 0; y < matrix.length; y++){
            for (int x = 0; x < matrix[0].length; x++){
                String fillColor;
                if(matrix[x][y]== 1){
                    fillColor = color;
                }else{
                    fillColor = "#000000";
                }
                pieceMatrix.add(new Point(x,y,fillColor));
            }
        }
        return pieceMatrix;
    }

    public void draw(TextGraphics screen){
        screen.setBackgroundColor(TextColor.Factory.fromString(color));

        for(Point point: matrix){
            if(point.getColor()!="#000000"){
                screen.putString(new TerminalPosition(pos_x + point.getX() + Game.getGameScreenXoffset(), pos_y + point.getY() + Game.getGameScreenYoffset()), " ");
            }

        }
    }

    public void moveLeft(){ pos_x-=2; }
    public void moveRight(){ pos_x+=2; }
    public void forceDown(){ pos_y++; }
    public int getBottomPos(){
        return pos_y + 1;
    }

}
