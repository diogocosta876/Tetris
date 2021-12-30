package ldts.model;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import ldts.model.MatrixOperations.*;
import ldts.model.PieceStates.*;

import java.util.Random;


public class Piece {
    private int pos_x;
    private int pos_y;
    private PieceState state;
    private String[][] matrix;

    public Piece(){
        pos_x = Game.getGameScreenWidth()/2;
        pos_y = 0;

        getRandomState();

        matrix = state.getMatrix();
    }

    private void getRandomState(){
        Random random = new Random();
        int x = random.nextInt(7);
        PieceState[] states = {new JPiece(), new LinePiece(), new LPiece(), new SPiece(), new SquarePiece(), new TPiece(), new ZPiece()};
        state = states[x];
    }

    public void rotate(){
        matrix = RotateMatrix.execute(matrix);
    }

    public void draw(TextGraphics screen){
        screen.setBackgroundColor(TextColor.Factory.fromString(state.getColor()));

        for(int y =0; y< matrix.length; y++){
            for (int x = 0; x < matrix[y].length*2; x+=2){
                if(matrix[y][x/2]!="#000000") {
                    //TODO REMOVE LINE (on to debug)
                    screen.putString(new TerminalPosition(pos_x*2 + x + Game.getGameScreenXoffset(), pos_y + y + Game.getGameScreenYoffset()), Integer.toString(pos_x + x/2));
                    //screen.putString(new TerminalPosition(pos_x*2 + x + ldts.model.Game.getGameScreenXoffset(), pos_y + y + ldts.model.Game.getGameScreenYoffset()), " ");
                    screen.putString(new TerminalPosition(pos_x*2 + x +1 + Game.getGameScreenXoffset(), pos_y + y + Game.getGameScreenYoffset()), " ");
                }
            }
        }
    }
    public void moveLeft(){ pos_x-=1; }
    public void moveRight(){ pos_x+=1; }
    public void forceDown(){ pos_y++; }

    public int getBottomPos(){
        return pos_y + matrix.length -1;
    }
    public int getRightPos(){
        return pos_x + matrix[0].length -1;
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
    public void setState(PieceState state) {
        this.state = state;
    }

}
