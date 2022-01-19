import com.googlecode.lanterna.TerminalSize
import com.googlecode.lanterna.graphics.TextGraphics
import com.googlecode.lanterna.screen.Screen
import com.googlecode.lanterna.screen.TerminalScreen
import com.googlecode.lanterna.terminal.DefaultTerminalFactory
import com.googlecode.lanterna.terminal.Terminal
import ldts.model.Piece
import ldts.model.PieceStates.SquarePiece
import ldts.view.NextPieceView
import spock.lang.Specification

class NextPieceViewTest extends Specification{
    def 'NextPieceView Test'(){
        given:
        def nextPiece = new Piece(0)
        def state = new SquarePiece()
        nextPiece.setState(state)

        Screen screen
        Terminal terminal
        try {
            TerminalSize terminalSize = new TerminalSize(70, 70)
            DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory().setInitialTerminalSize(terminalSize)
            terminal = terminalFactory.createTerminal()
            screen = new TerminalScreen(terminal)
            screen.setCursorPosition(null)
            screen.startScreen()
            screen.doResizeIfNecessary()
        } catch (IOException e) {
            e.printStackTrace()
        }
        TextGraphics screenGraphics = screen.newTextGraphics()

        when:
        NextPieceView nextPieceView = new NextPieceView(nextPiece)
        nextPieceView.draw(screenGraphics)
        screen.refresh()

        then:
        def i=52 //column where nextPiece is drawn
        def j=11 //row where nextPiece is drawn

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
