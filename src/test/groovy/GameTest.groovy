import ldts.model.Board
import ldts.model.Game;
import ldts.model.Piece;
import ldts.model.PieceStates.SquarePiece;
import spock.lang.Specification;

public class GameTest extends Specification {
    def 'nextTick'(){
        given:
        Game game = new Game()
        game.isPieceNull()

        when:
        game.nextTick();

        then:
        game.getTickCount() == 1

        when:
        while(game.getTickCount() < game.getGameSpeed()){
            game.nextTick()
        }
        game.nextTick()

        then:
        game.getTickCount() == 0
    }
    def 'isPieceNull'(){
        given:
        Game game = new Game()
        game.isPieceNull()

        when:
        while(!game.board.hasHitBottom(game.piece)){
            game.nextTick()
        }
        game.pressedDown()
        then:
        game.isPieceNull()
    }
    def 'pressedLeft'(){
        given:
        Game game = new Game()
        game.isPieceNull()

        when:
        def initial_pos_x = game.getPiece().getPos_x()
        game.pressedLeft()
        then:
        game.getPiece().getPos_x() == initial_pos_x-1
    }
    def 'pressedRight'(){
        given:
        Game game = new Game()
        game.isPieceNull()

        when:
        def initial_pos_x = game.getPiece().getPos_x()
        game.pressedRight()
        then:
        game.getPiece().getPos_x() == initial_pos_x+1
    }
    def 'pressedUp'(){
        given:
        Game game = new Game()
        game.isPieceNull()

        when:
        def initial_matrix = game.getPiece().getMatrix()
        game.pressedUp()
        then:
        game.getPiece().getMatrix() != initial_matrix
    }
    def 'pressedDown'(){
        given:
        Game game = new Game()
        game.isPieceNull()

        when:
        def initial_pos_y = game.getPiece().getPos_y()
        game.pressedDown()
        then:
        game.getPiece().getPos_y() == initial_pos_y + 1
    }
}