package ldts.view;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import ldts.controller.GameController;
import ldts.model.Board;
import ldts.model.Game;
import ldts.model.Piece;
import ldts.model.PieceStates.PieceState;

public class BoardView extends View<Board>{

    private String[][] matrix;
    private int length;
    private int width;

    public BoardView(Board model) {
        this.model = model;
    }

    public void update(){
        this.matrix = model.getMatrix();
        this.length = model.getLength();
        this.width = model.getWidth();
    }

    public void draw(TextGraphics screen) {
        update();
        for (int y = 0; y < length; y++){
            for (int x = 0; x < width*2; x+=2){
                screen.setBackgroundColor(TextColor.Factory.fromString(matrix[y][x/2]));
                //TODO REMOVE LINE (on to debug)
                screen.putString(new TerminalPosition(x + GameController.getGameScreenXoffset(), y + GameController.getGameScreenYoffset()), " ");
                //screen.putString(new TerminalPosition(x + ldts.model.Game.getGameScreenXoffset(), y + ldts.model.Game.getGameScreenYoffset()), ' ');
                screen.putString(new TerminalPosition(x+1 + GameController.getGameScreenXoffset(), y + GameController.getGameScreenYoffset()), " ");
            }
        }
    }
}
