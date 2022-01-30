package ldts

import com.googlecode.lanterna.TerminalSize
import com.googlecode.lanterna.screen.Screen
import com.googlecode.lanterna.screen.TerminalScreen
import com.googlecode.lanterna.terminal.DefaultTerminalFactory
import com.googlecode.lanterna.terminal.Terminal
import ldts.controller.InstructionsController
import ldts.model.Game
import ldts.model.HighDifficultyOrder
import spock.lang.Specification

class InstructionsControllerTest extends Specification{
    def"CheckDifficultyChanges"(){
        given:

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

        def game = new Game()
        def orderHigh = new HighDifficultyOrder(game)
        InstructionsController instructionsController = new InstructionsController(screen,game)
        when:
        instructionsController.orderQueue.add(orderHigh)
        then:
        instructionsController.checkDifficultyChanges() == "High Difficulty"
    }
}
