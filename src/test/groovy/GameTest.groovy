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
        while(!game.getBoard().hasHitBottom(game.piece)){
            game.nextTick()
        }
        then:
        game.isPieceNull() == false

        when:
        game.pressedDown()
        then:
        game.isPieceNull() == true
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
        if(game.getPiece().state.color!="#0033CC"){
            game.getPiece().getMatrix() != initial_matrix
        }
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
    def 'hasHitBottom Test'(){
        given:
        Game game = new Game()
        game.isPieceNull()

        when:
        while(!game.getBoard().hasHitBottom(game.getPiece()) || game.getTickCount()!=5){
            game.nextTick()
        }
        game.nextTick()


        then:
        System.out.println(game.getTickCount())
        game.getPiece() == null

    }

    def 'Next Piece Test'(){
        given:
        Game game = new Game()

        when:
        game.getNextPiece()
        then:
        game.getNextPiece() == null

        when:
        game.isPieceNull()
        while(!game.getBoard().hasHitBottom(game.getPiece()) || game.getTickCount()!=5){
            game.nextTick()
        }
        game.nextTick()
        def secondPiece = game.getNextPiece()
        game.isPieceNull()

        then:
        game.getPiece() == secondPiece


    }

    def 'Initial Score Test'(){
        given:
        Game game = new Game()

        when:
        game.isPieceNull()

        then:
        game.getScore().getScore() ==0

    }
}