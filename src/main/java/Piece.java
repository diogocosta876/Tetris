import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;

import java.util.ArrayList;
import java.util.List;

public class Piece {
    private int[][] matrix;
    int pos_x = Game.getGameScreenWidth()/2-1, pos_y =1;

    public Piece(){
        matrix = new int[][]{
                {0,0,0,0},
                {0,1,1,0},
                {0,1,1,0},
                {0,0,0,0}};
    }

    public void moveLeft(){ pos_x-=2; }
    public void moveRight(){ pos_x+=2; }
    public void forceDown(){ pos_y++; }

    public void draw(TextGraphics screen){
        screen.setBackgroundColor(TextColor.Factory.fromString("#0033CC"));

        //Iterate piece matrix to draw it, using it's position
        for (int y = 0; y < 4; y++){
            for (int x = 0; x < 8; x++){
                if (matrix[y][x/2] == 1)
                    screen.putString(new TerminalPosition(pos_x + x - 2 + Game.getGameScreenXoffset(), pos_y + y - 2 + Game.getGameScreenYoffset()), " ");
            }
        }
    }
}
