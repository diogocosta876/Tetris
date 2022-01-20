package ldts.controller;

import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import java.io.IOException;

public class MenuController {

    boolean on = true;
    private Screen screen;
    private GameController gameController;
    private InstructionsController instructionsMenu;

    public MenuController(){

    }

    public void setup(){
        try {
            TerminalSize terminalSize = new TerminalSize(75, 30);
            DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory().setInitialTerminalSize(terminalSize);
            Terminal terminal = terminalFactory.createTerminal();
            screen = new TerminalScreen(terminal);
            screen.setCursorPosition(null);
            screen.startScreen();
            screen.doResizeIfNecessary();
            gameController = new GameController(screen);
            instructionsMenu = new InstructionsController(screen,gameController.getGame());
        } catch (
                IOException e) {
            e.printStackTrace();
        }
    }

    public void run(){

    }

    public void inputReceiver(){

    }


    public void draw() throws IOException{

    }
}