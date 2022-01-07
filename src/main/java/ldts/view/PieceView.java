package ldts.view;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import ldts.controller.GameController;
import ldts.model.Game;
import ldts.model.Piece;
import ldts.model.PieceStates.PieceState;

public class PieceView extends View<Piece> {

    private String[][] matrix;
    private PieceState state;
    private int pos_x;
    private int pos_y;

    public PieceView(Piece model) {
        this.model = model;
        this.matrix = model.getMatrix();
        this.state = model.getState();
        this.pos_x = model.getPos_x();
        this.pos_y = model.getPos_y();
    }

    public void update() {
        this.matrix = model.getMatrix();
        this.state = model.getState();
        this.pos_x = model.getPos_x();
        this.pos_y = model.getPos_y();
    }

    public void draw(TextGraphics screen) {
        update();
        screen.setBackgroundColor(TextColor.Factory.fromString(state.getColor()));

        for (int y = 0; y < matrix.length; y++) {
            for (int x = 0; x < matrix[y].length * 2; x += 2) {
                if (matrix[y][x / 2] != "#000000") {
                    //TODO REMOVE LINE (on to debug)
                    screen.putString(new TerminalPosition(pos_x * 2 + x + GameController.getGameScreenXoffset(), pos_y + y + GameController.getGameScreenYoffset()), " ");
                    //screen.putString(new TerminalPosition(pos_x*2 + x + ldts.model.Game.getGameScreenXoffset(), pos_y + y + ldts.model.Game.getGameScreenYoffset()), " ");
                    screen.putString(new TerminalPosition(pos_x * 2 + x + 1 + GameController.getGameScreenXoffset(), pos_y + y + GameController.getGameScreenYoffset()), " ");
                }
            }
        }
    }
}
