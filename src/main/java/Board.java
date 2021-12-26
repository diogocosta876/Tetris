import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

public class Board {
    private int[][] matrix;

    public Board(){
        matrix = new int[Game.getGameScreenLength()][Game.getGameScreenWidth()];
        for (int y = 0; y < Game.getGameScreenLength(); y++){
            for (int x = 0; x < Game.getGameScreenWidth(); x++){
                matrix[y][x] = 0;
            }
        }
    }

    public void draw(TextGraphics screen) {

        //Iterate piece matrix to draw it, using it's position
        for (int y = 0; y < Game.getGameScreenLength(); y++) {
            for (int x = 0; x < Game.getGameScreenWidth(); x++) {
                if (matrix[y][x] == 1) {
                    screen.setBackgroundColor(TextColor.Factory.fromString("#111111"));
                    screen.putString(new TerminalPosition(x + Game.getGameScreenXoffset(), y + Game.getGameScreenYoffset()), " ");
                }
                else{
                    screen.setBackgroundColor(TextColor.Factory.fromString("#000000"));
                    screen.putString(new TerminalPosition(x + Game.getGameScreenXoffset(), y + Game.getGameScreenYoffset()), " ");
                }
            }
        }
    }
}
