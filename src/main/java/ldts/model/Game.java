package ldts.model;

import com.googlecode.lanterna.*;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.graphics.TextGraphics;
import ldts.controller.keyController;
import ldts.model.PieceStates.*;

import java.io.IOException;
import java.util.Random;

public class Game {

    private Screen screen;
    private static final int gameScreenXoffset = 6;
    private static final int gameScreenYoffset = 2;
    private static final int gameScreenWidth = 26;
    private static final int gameScreenLength= 26;
    private static int gameSpeed = 5;  //smaller is faster, ticks needed to force piece down
    private int nTickCounter = 0;

    private Board board;
    private Piece piece;

    public Game() {
        try {
            TerminalSize terminalSize = new TerminalSize(75, 30);
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

        //NEXT PIECE - will need refactoring
        screenGraphics.setBackgroundColor(TextColor.Factory.fromString("#3A3A3A"));
        screenGraphics.putString(45,2, " _  _ _____  _______   ");
        screenGraphics.putString(45,3, "| \\| | __\\ \\/ /_   _|");
        screenGraphics.putString(45,4, "| .` | _| >  <  | | ");
        screenGraphics.putString(45,5, "|_|\\_|___/_/\\_\\ |_|");
        screenGraphics.setBackgroundColor(TextColor.Factory.fromString("#000000"));
        screenGraphics.fillRectangle(new TerminalPosition(45,7), new TerminalSize(20, 10), ' ');

        //SCORE - will need refactoring
        screenGraphics.setBackgroundColor(TextColor.Factory.fromString("#3A3A3A"));
        screenGraphics.putString(42,18, "  ___  ___ ___  ___ ___");
        screenGraphics.putString(42,19, " / __|/ __/ _ \\| _ \\ __|");
        screenGraphics.putString(42,20, " \\__ \\ (_| (_) |   / _|");
        screenGraphics.putString(42,21, " |___/\\___\\___/|_|_\\___|");
        screenGraphics.putString(52,24, "0700", SGR.BOLD);


        board.draw(screenGraphics);
        piece.draw(screenGraphics);

        screen.refresh();
    }


    public void run() throws IOException {
        while(true) {
            //game timing
            try {
                Thread.sleep(100);
            } catch (InterruptedException ex) { ex.printStackTrace(); }

            //Game Logic
            if (piece == null){
                piece = new Piece();
                board.checkLineCompletition();
            }

            if (nTickCounter == gameSpeed ) {
                if(board.hasHitBottom(piece)){
                    piece = null;
                    nTickCounter = 0;
                    continue;
                }
                piece.forceDown();
                nTickCounter = 0;
            } else {
                nTickCounter++;
            }

            //input
            if (keyController.isLeftPressed() && piece.getPos_x()>0 && board.canMove(piece.getPos_x()-1, piece)) {  //TODO add method board.canMove()
                //System.out.println("left pressed");
                //move left horizontally
                piece.moveLeft();
            }
            if (keyController.isRightPressed() && piece.getRightPos()<gameScreenWidth/2-1 && board.canMove(piece.getPos_x()+1, piece)) {
                //System.out.println("right pressed");
                //move right horizontally
                piece.moveRight();
            }
            if (keyController.isUpPressed()) {
                //System.out.println("up pressed");
                piece.rotate();
            }
            if (keyController.isDownPressed()) {
                //force down
                if(board.hasHitBottom(piece)){
                    piece = null;
                    nTickCounter = 0;
                    continue;
                }
                piece.forceDown();
                nTickCounter = 0;
            }
            if (keyController.isEscPressed()) {
                screen.close();
                System.exit(0);
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
    public static int getGameScreenWidth(){ return gameScreenWidth/2; }
    public static int getGameScreenLength(){
        return gameScreenWidth;
    }
}
