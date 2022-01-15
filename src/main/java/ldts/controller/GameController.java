package ldts.controller;

import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import ldts.model.Board;
import ldts.model.Game;
import ldts.model.Piece;
import ldts.view.BoardView;
import ldts.view.PieceView;
import ldts.view.ScoreView;

import java.io.IOException;

public class GameController extends Game{
    boolean on = true;
    private Game game;
    private Screen screen;
    private PieceView pieceview;
    private BoardView boardview;
    private ScoreView scoreView;

    public GameController() {
        game = new Game();
        boardview = new BoardView(game.getBoard());
        scoreView = new ScoreView(game.getScore());
        setup();
    }

    public void setup() {
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
    }

    public void run() throws IOException {
        while (on) {

            //game timing
            try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }

            //Game Logic
            if (game.isPieceNull()) {
                pieceview = new PieceView(game.getPiece());
            }
            game.nextTick();

            //input
            sendInputToModel();

            //render output
            try {
                draw();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

    }

    public void draw() throws IOException {
        screen.clear();
        //initialize and draw background
        TextGraphics screenGraphics = screen.newTextGraphics();
        screenGraphics.setBackgroundColor(TextColor.Factory.fromString("#3A3A3A"));
        screenGraphics.fillRectangle(new TerminalPosition(0, 0), new TerminalSize(80, 40), ' ');

        //NEXT PIECE - will need refactoring
        screenGraphics.setBackgroundColor(TextColor.Factory.fromString("#3A3A3A"));
        screenGraphics.putString(45, 2, " _  _ _____  _______   ");
        screenGraphics.putString(45, 3, "| \\| | __\\ \\/ /_   _|");
        screenGraphics.putString(45, 4, "| .` | _| >  <  | | ");
        screenGraphics.putString(45, 5, "|_|\\_|___/_/\\_\\ |_|");
        screenGraphics.setBackgroundColor(TextColor.Factory.fromString("#000000"));
        screenGraphics.fillRectangle(new TerminalPosition(45, 7), new TerminalSize(20, 10), ' ');

        //SCORE - will need refactoring

        scoreView.draw(screenGraphics);
        boardview.draw(screenGraphics);
        pieceview.draw(screenGraphics);

        screen.refresh();
    }

    public static int getGameScreenXoffset() {
        return gameScreenXoffset;
    }
    public static int getGameScreenYoffset() {
        return gameScreenYoffset;
    }
    public static int getGameScreenWidth() {
        return gameScreenWidth / 2;
    }
    public static int getGameScreenLength() {
        return gameScreenWidth;
    }

    public void sendInputToModel() throws IOException {
        if (keyController.isLeftPressed()) {
            game.pressedleft();
        }
        if (keyController.isRightPressed()) {
            game.pressedRight();
        }
        if (keyController.isUpPressed()) {
            game.pressedUp();
        }
        if (keyController.isDownPressed()) {
            game.pressedDown();
        }
        if (keyController.isEscPressed()) {
            on = false;
            screen.close();
        }
    }

}
