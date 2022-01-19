import com.googlecode.lanterna.TerminalSize
import com.googlecode.lanterna.graphics.TextGraphics
import com.googlecode.lanterna.screen.Screen
import com.googlecode.lanterna.screen.TerminalScreen
import com.googlecode.lanterna.terminal.DefaultTerminalFactory
import com.googlecode.lanterna.terminal.Terminal
import ldts.model.Score
import ldts.view.ScoreView
import spock.lang.Specification

class ScoreViewTest extends Specification{
    def 'ScoreView Test'(){
        given:
        Score score = new Score()

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

        ScoreView scoreView = new ScoreView(score)
        scoreView.draw(screenGraphics)
        screen.refresh()

        then:
        screenGraphics.getCharacter(52,24).character == '0' as char
    }
}
