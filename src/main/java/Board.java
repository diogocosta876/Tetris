import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class Board {
    private String[][] matrix;

    private int width;
    private int length;

    public Board(int width, int length){
        this.width = width;
        this.length = length;

        matrix = new String[length][width];

        for (int y = 0; y < length; y++){
            for (int x = 0; x < width; x++){
                matrix[y][x] = "#000000";
                System.out.println("element added");
            }
        }
    }

    public void draw(TextGraphics screen) {
        for (int y = 0; y < length; y++){
            for (int x = 0; x < width; x++){
                screen.setBackgroundColor(TextColor.Factory.fromString(matrix[y][x]));
                screen.putString(new TerminalPosition(x + Game.getGameScreenXoffset(), y + Game.getGameScreenYoffset()), " ");
            }
        }
    }

    public boolean stop(Piece piece){
        if(piece.getBottomPos()+1>=length){
            System.out.println("Chegou ao Fundo");
            addPiece(piece);
            return true;
        }
        for(int y =0; y<piece.getMatrix().length; y++){
            for (int x = 0; x <piece.getMatrix()[y].length; x++){
                if(piece.getMatrix()[y][x]!="#000000") {
                    if(matrix[y+piece.getPos_y()+1][x+ piece.getPos_x()]!="#000000"){
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

}
