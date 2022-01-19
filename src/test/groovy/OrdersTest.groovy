import ldts.model.Game
import ldts.model.HighDifficultyOrder
import ldts.model.LowDifficultyOrder
import ldts.model.Order
import spock.lang.Specification

class OrdersTest extends Specification{
    def "High and Low Difficulty Orders Test"(){
        given:
        def game = new Game()
        def game1 = new Game()
        when:
        def highDifficultyOrder = new HighDifficultyOrder(game)
        def lowDifficultyOrder = new LowDifficultyOrder(game1)

        highDifficultyOrder.execute()
        lowDifficultyOrder.execute()
        then:
        game.getGameSpeed() == 4
        game1.getGameSpeed() == 6
    }
}
