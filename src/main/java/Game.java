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
        screenGraphics.fillRectangle(new TerminalPosition(0,0), new TerminalSize(90, 40), ' ');
        screenGraphics.setCharacter(2,2,'m');
        screenGraphics.setBackgroundColor(TextColor.Factory.fromString("#000000"));
        screenGraphics.fillRectangle(new TerminalPosition(2,2), new TerminalSize(40, 32), ' ');

        //NEXT PIECE
        screenGraphics.setBackgroundColor(TextColor.Factory.fromString("#3A3A3A"));
        screenGraphics.putString(48,3, " _  _ _____  _______   ");
        screenGraphics.putString(48,4, "| \\| | __\\ \\/ /_   _|");
        screenGraphics.putString(48,5, "| .` | _| >  <  | | ");
        screenGraphics.putString(48,6, "|_|\\_|___/_/\\_\\ |_|");
        screenGraphics.setBackgroundColor(TextColor.Factory.fromString("#000000"));
        screenGraphics.fillRectangle(new TerminalPosition(48,8), new TerminalSize(20, 10), ' ');

        //SCORE
        screenGraphics.setBackgroundColor(TextColor.Factory.fromString("#3A3A3A"));
        screenGraphics.putString(46,20, "  ___  ___ ___  ___ ___");
        screenGraphics.putString(46,21, " / __|/ __/ _ \\| _ \\ __|");
        screenGraphics.putString(46,22, " \\__ \\ (_| (_) |   / _|");
        screenGraphics.putString(46,23, " |___/\\___\\___/|_|_\\___|");
        screenGraphics.putString(57,26, "0700", SGR.BOLD);

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
            while(true) {
                draw();
                com.googlecode.lanterna.input.KeyStroke key = screen.readInput();
                processKey(key);

                if (key.getKeyType() == KeyType.Character && key.getCharacter() == ('q'))
                    screen.close();
                if (key.getKeyType() == KeyType.EOF)
                    break;
            }
        } catch (IOException e){
            e.printStackTrace();
        }

    }
}
