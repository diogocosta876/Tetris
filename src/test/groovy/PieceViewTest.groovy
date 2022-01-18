import ldts.controller.GameController
import ldts.model.Piece
import ldts.model.PieceStates.SquarePiece
import ldts.view.PieceView
import spock.lang.Specification

import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

class PieceViewTest extends Specification{
    def 'PieceView Test'(){
        given:
        def piece = new Piece(0);
        def state = new SquarePiece();
        piece.setState(state);

        Screen screen;
        Terminal terminal;
        try {
            TerminalSize terminalSize = new TerminalSize(70, 70);
            DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory().setInitialTerminalSize(terminalSize);
            terminal = terminalFactory.createTerminal();
            screen = new TerminalScreen(terminal);
            screen.setCursorPosition(null);
            screen.startScreen();
            screen.doResizeIfNecessary();
        } catch (IOException e) {
            e.printStackTrace();
        }
        TextGraphics screenGraphics = screen.newTextGraphics();

        when:
        PieceView pv = new PieceView(piece);
        pv.draw(screenGraphics);
        screen.refresh();

        def i = GameController.gameScreenXoffset;
        def j = GameController.gameScreenYoffset;
        def color = screenGraphics.getCharacter(i,j).backgroundColor.red;

        then:
        screenGraphics.getCharacter(i,j).backgroundColor.red==0
        screenGraphics.getCharacter(i,j).backgroundColor.green==51
        screenGraphics.getCharacter(i,j).backgroundColor.blue==204
        screenGraphics.getCharacter(i+1,j).backgroundColor.red==0
        screenGraphics.getCharacter(i+1,j).backgroundColor.green==51
        screenGraphics.getCharacter(i+1,j).backgroundColor.blue==204
        screenGraphics.getCharacter(i+1,j+1).backgroundColor.red==0
        screenGraphics.getCharacter(i+1,j+1).backgroundColor.green==51
        screenGraphics.getCharacter(i+1,j+1).backgroundColor.blue==204
        screenGraphics.getCharacter(i,j+1).backgroundColor.red==0
        screenGraphics.getCharacter(i,j+1).backgroundColor.green==51
        screenGraphics.getCharacter(i,j+1).backgroundColor.blue==204

        screenGraphics.getCharacter(i-1,j).backgroundColor.red==0
        screenGraphics.getCharacter(i-1,j).backgroundColor.green==0
        screenGraphics.getCharacter(i-1,j).backgroundColor.blue==0




    }

}
