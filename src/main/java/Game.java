import com.googlecode.lanterna.*;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.graphics.TextGraphics;
import java.io.IOException;

public class Game {

    private Screen screen;
    private static final int gameScreenXoffset = 4;
    private static final int gameScreenYoffset = 2;
    private static final int gameScreenWidth = 30;
    private static final int gameScreenLength= 30;
    private static int gameSpeed = 5;  //smaller is faster, ticks needed to force piece down
    private int nTickCounter = 0;

    private Board board;
    private Piece piece;

    public Game() {
        try {
            TerminalSize terminalSize = new TerminalSize(75, 35);
            DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory().setInitialTerminalSize(terminalSize);
            Terminal terminal = terminalFactory.createTerminal();
            screen = new TerminalScreen(terminal);
            screen.setCursorPosition(null);
            screen.startScreen();
            screen.doResizeIfNecessary();
        } catch (
                IOException e) {
            e.printStackTrace();
        }
        board = new Board(gameScreenWidth,gameScreenLength);
    }

    private void draw() throws IOException{
        screen.clear();
        //initialize and drawn background
        TextGraphics screenGraphics = screen.newTextGraphics();
        screenGraphics.setBackgroundColor(TextColor.Factory.fromString("#3A3A3A"));
        screenGraphics.fillRectangle(new TerminalPosition(0,0), new TerminalSize(80, 40), ' ');

        //draw game screen
        screenGraphics.setBackgroundColor(TextColor.Factory.fromString("#000000"));
        screenGraphics.fillRectangle(new TerminalPosition(gameScreenXoffset,gameScreenYoffset), new TerminalSize(gameScreenWidth, gameScreenLength), ' ');

        //NEXT PIECE - will need refactoring
        screenGraphics.setBackgroundColor(TextColor.Factory.fromString("#3A3A3A"));
        screenGraphics.putString(45,3, " _  _ _____  _______   ");
        screenGraphics.putString(45,4, "| \\| | __\\ \\/ /_   _|");
        screenGraphics.putString(45,5, "| .` | _| >  <  | | ");
        screenGraphics.putString(45,6, "|_|\\_|___/_/\\_\\ |_|");
        screenGraphics.setBackgroundColor(TextColor.Factory.fromString("#000000"));
        screenGraphics.fillRectangle(new TerminalPosition(45,8), new TerminalSize(20, 10), ' ');

        //SCORE - will need refactoring
        screenGraphics.setBackgroundColor(TextColor.Factory.fromString("#3A3A3A"));
        screenGraphics.putString(42,20, "  ___  ___ ___  ___ ___");
        screenGraphics.putString(42,21, " / __|/ __/ _ \\| _ \\ __|");
        screenGraphics.putString(42,22, " \\__ \\ (_| (_) |   / _|");
        screenGraphics.putString(42,23, " |___/\\___\\___/|_|_\\___|");
        screenGraphics.putString(52,26, "0700", SGR.BOLD);


        board.draw(screenGraphics);
        piece.draw(screenGraphics);
        if(board.stop(piece)){
            piece = null;
        }

        screen.refresh();
    }


    public void run() throws IOException {
        while(true) {
            //game timing
            try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }

            //game logic
            if (piece == null)
                piece = new Piece();

            //input
            if (keyController.isLeftPressed()&& piece.getPos_x()-1>0) {
                System.out.println("left pressed");
                //move left horizontally
                piece.moveLeft();
            }
            if (keyController.isRightPressed() && piece.getRightPos()+1<gameScreenWidth) {
                System.out.println("right pressed");
                //move right horizontally
                piece.moveRight();
            }
            if (keyController.isUpPressed()) {
                System.out.println("up pressed");
                //TODO Rotate
            }
            if (keyController.isDownPressed()) {
                //force down
                System.out.println("down pressed");
                piece.forceDown();
            }
            if (keyController.isEscPressed()) {
                screen.close();
                System.exit(0);
            }


            if (nTickCounter == gameSpeed ) {
                piece.forceDown();
                nTickCounter = 0;
            } else {
                nTickCounter++;
            }

            //render output
            try {
                draw();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

    }


    public static int getGameScreenXoffset(){
        return gameScreenXoffset;
    }
    public static int getGameScreenYoffset(){
        return gameScreenYoffset;
    }
    public static int getGameScreenWidth(){
        return gameScreenWidth;
    }
    public static int getGameScreenLength(){
        return gameScreenWidth;
    }
}
