import com.googlecode.lanterna.*;
import com.googlecode.lanterna.input.KeyType;
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
    }

    private void draw() throws IOException{
        screen.clear();
        TextGraphics screenGraphics = screen.newTextGraphics();
        screenGraphics.setBackgroundColor(TextColor.Factory.fromString("#3A3A3A"));
        screenGraphics.fillRectangle(new TerminalPosition(0,0), new TerminalSize(80, 40), ' ');
        screenGraphics.setBackgroundColor(TextColor.Factory.fromString("#000000"));
        screenGraphics.fillRectangle(new TerminalPosition(gameScreenXoffset,gameScreenYoffset), new TerminalSize(gameScreenWidth, gameScreenLength), ' ');

        Piece my_piece = new Piece();
        my_piece.draw(screenGraphics);


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

        screen.refresh();
    }

    private void processKey(com.googlecode.lanterna.input.KeyStroke key){
        System.out.println(key);
        switch (key.getKeyType()) {
            case ArrowUp    -> System.out.println("moving");
            case ArrowDown  -> System.out.println("moving");
            case ArrowLeft  -> System.out.println("moving");
            case ArrowRight -> System.out.println("moving");
        }
    }

    public void run() {
        try {
            draw();
            while(true) {
                //game timing
                Thread.sleep(100);
                System.out.println("tick");

                //input
                //com.googlecode.lanterna.input.KeyStroke key = screen.readInput();
                //processKey(key);
                if (Controller.isLeftPressed()){
                    System.out.println("left pressed");
                }
                if (Controller.isRightPressed()){
                    System.out.println("right pressed");
                }
                if (Controller.isUpPressed()){
                    System.out.println("up pressed");
                }
                if (Controller.isDownPressed()){
                    System.out.println("down pressed");
                }
                if (Controller.isEscPressed()){
                    screen.close();
                    System.exit(0);
                }

                //game logic


                //render output
                draw();

            }
        } catch (IOException e){
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
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
