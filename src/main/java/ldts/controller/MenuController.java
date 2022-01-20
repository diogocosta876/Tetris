package ldts.controller;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import ldts.model.Order;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MenuController {

    boolean on = true;
    private Screen screen;
    private GameController gameController;
    private InstructionsController instructionsMenu;

    public MenuController(){
        setup();
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

    public void run() throws IOException{
        while(on){
            try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
            inputReceiver();
            try {
                draw();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    public void inputReceiver() throws IOException{
        if (keyController.isZeroPressed()) {
            gameController.setOn();
            gameController.run();
        }
        else if (keyController.isOnePressed()) {
            instructionsMenu.setOn();
            instructionsMenu.run();
        }
        if (keyController.isTwoPressed()) {
            on = false;
            screen.close();
        }
        if (keyController.isEscPressed()) {
            //
        }
    }


    public void draw() throws IOException{
        screen.clear();

        TextGraphics screenGraphics = screen.newTextGraphics();
        screenGraphics.setBackgroundColor(TextColor.Factory.fromString("#3A3A3A"));
        screenGraphics.fillRectangle(new TerminalPosition(0, 0), new TerminalSize(80, 40), ' ');

        //future refactor

        screenGraphics.putString(10,10,"0) Play Game");
        screenGraphics.putString(10,15,"1) Change Difficulty");
        screenGraphics.putString(10,20,"2) Exit");
        screen.refresh();
    }


}