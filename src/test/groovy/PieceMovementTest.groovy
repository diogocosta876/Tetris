import spock.lang.Specification

import java.awt.event.KeyEvent;

class PieceMovementTest extends Specification{

    def 'Piece Move Left'() {
        given:
        def piece = new SquarePiece();
        def board = new Board();

        when:
        def initial_pos = piece.pos_x
        piece.moveLeft()

        then:
        piece.pos_x == initial_pos - 2
    }
    def 'Piece Move Right'() {
        given:
        def piece = new SquarePiece();
        def board = new Board();

        when:
        def initial_pos = piece.pos_x
        piece.moveRight()

        then:
        piece.pos_x == initial_pos + 2
    }
    def 'Piece Move Down'() {
        given:
        def piece = new SquarePiece();
        def board = new Board();

        when:
        def initial_pos = piece.pos_y
        piece.forceDown()

        then:
        piece.pos_y == initial_pos + 1
    }

}
