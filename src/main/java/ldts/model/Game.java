package ldts.model;

import com.googlecode.lanterna.*;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.graphics.TextGraphics;
import ldts.controller.GameController;
import ldts.controller.keyController;
import ldts.model.PieceStates.*;
import ldts.view.PieceView;
import ldts.model.Score;

import java.io.IOException;
import java.util.Random;

public class Game {

    protected Board board;
    protected Piece piece;
    protected  Piece nextPiece;
    protected static final int gameScreenXoffset = 6;
    protected static final int gameScreenYoffset = 2;
    protected static final int gameScreenWidth = 26;
    protected static final int gameScreenLength = 26;
    protected static int gameSpeed = 5;  //smaller is faster, ticks needed to force piece down
    protected int nTickCounter = 0;
    protected Score score;

    public Game(){
        board = new Board(gameScreenWidth, gameScreenLength);
        score = new Score();
    }

    public void nextTick(){
        score.addToScore(board.checkLineCompletition(new RemoveLine()));
        if (nTickCounter == gameSpeed) {
            if (board.hasHitBottom(piece))
                piece = null;
            else
                piece.forceDown();
            nTickCounter = 0;
        } else {
            nTickCounter++;
        }
    }
    public boolean isPieceNull(){
        if(nextPiece == null && piece == null){
            piece = new Piece(gameScreenWidth/4);
            nextPiece = new Piece(gameScreenWidth/4);
            return true;
        }
        if (piece == null) {
            piece = nextPiece;
            nextPiece = null;
            nextPiece = new Piece(gameScreenWidth/4);
            return true;
        }
        return false;
    }

    public void pressedLeft(){
         if (piece.getPos_x()>0 && board.canMove(piece.getPos_x()-1, piece))
            piece.moveLeft();
    }
    public void pressedRight(){
        if (piece.getRightPos()<gameScreenWidth/2-1 && board.canMove(piece.getPos_x()+1, piece))
            piece.moveRight();
    }
    public void pressedDown(){
        if(board.hasHitBottom(piece))
            piece = null;
        else
            piece.forceDown();
        nTickCounter = 0;
    }
    public void pressedUp(){
        if(piece!=null && board.canRotate(piece)){
            piece.rotate();
        }
    }

    public Piece getPiece() {
        return piece;
    }
    public Piece getNextPiece(){return nextPiece;}
    public Board getBoard() {
        return board;
    }
    public Score getScore() { return score; }
    public static int getGameSpeed() {
        return gameSpeed;
    }
    public int getTickCount() {
        return nTickCounter;
    }
    public boolean increaseGameSpeed(){
        if(gameSpeed > 1){
            gameSpeed--;
            return true;
        }
        else{
            return false;
        }
    }
    public boolean decreaseGameSpeed(){
        if(gameSpeed<10){
            gameSpeed++;
            return true;
        }
        else{
            return false;
        }
    }
}
