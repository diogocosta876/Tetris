import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class Board {
    private List<Point> matrix;

    private int width;
    private int length;

    public Board(int width, int length){
        this.width = width;
        this.length = length;

        matrix = new ArrayList<>();

        for (int y = 0; y < length; y++){
            for (int x = 0; x < width; x++){
                matrix.add(new Point(x,y,"#000000"));
                System.out.println("element added");
            }
        }
    }

    public void draw(TextGraphics screen) {
        for(Point point: matrix){
            screen.setBackgroundColor(TextColor.Factory.fromString(point.getColor()));
            screen.putString(new TerminalPosition(point.getX() + Game.getGameScreenXoffset(), point.getY() + Game.getGameScreenYoffset()), " ");
        }
    }


    public boolean stop(Piece piece){
        if(piece.getBottomPos()+1>=length){
            System.out.println("Chegou ao Fundo");


            return true;
        }
        return false;
    }

    public void addPiece(Piece piece){

    }

}
