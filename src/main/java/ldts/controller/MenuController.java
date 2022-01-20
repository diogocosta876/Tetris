package ldts.controller;

import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.terminal.swing.AWTTerminalFontConfiguration;
import ldts.model.Order;

import java.awt.*;
import java.io.File;
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
            terminalFactory.setForceAWTOverSwing(true);

            try{
            terminalFactory.setTerminalEmulatorFontConfiguration(loadFont());
            }
            catch(IOException | FontFormatException e){}

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

    public AWTTerminalFontConfiguration loadFont() throws FontFormatException, IOException {
        File fontFile = new File("src/main/resources/square.ttf");
        Font font = Font.createFont(Font.TRUETYPE_FONT, fontFile);

        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        ge.registerFont(font);

        Font loadedFont = font.deriveFont(Font.PLAIN,10);
        return AWTTerminalFontConfiguration.newInstance(loadedFont);
    }

    private void drawText(TextGraphics textGraphics, int col, int row, String text, String color) {
        textGraphics.setForegroundColor(TextColor.Factory.fromString(color));
        textGraphics.enableModifiers(SGR.BOLD);
        textGraphics.putString(col,row,text);
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

        screenGraphics.putString(7,3,"___________________________________________ .___   _________");
        screenGraphics.putString(7,4,"\\__    ___/\\_   _____/\\__    ___/\\______   \\|   | /   _____/");
        screenGraphics.putString(7,5,"  |    |    |    __)_   |    |    |       _/|   | \\_____  \\ ");
        screenGraphics.putString(7,6,"  |    |    |        \\  |    |    |    |   \\|   | /        \\");
        screenGraphics.putString(7,7,"  |____|   /_______  /  |____|    |____|_  /|___|/_______  /");
        screenGraphics.putString(7,8,"                   \\/                    \\/              \\/ ");

        drawText(screenGraphics,10,12,"0) Play Game","#FFFFFF");
        drawText(screenGraphics,10,17,"1) Change Difficulty","#FFFFFF");
        drawText(screenGraphics,10,22,"2) Exit","#FFFFFF");
        screen.refresh();
    }


}