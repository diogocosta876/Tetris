package ldts

import ldts.model.Piece
import spock.lang.Specification

class PieceMovementTest extends Specification{

    def 'model.Piece Move Left'() {
        given:
        def piece = new Piece(5)

        when:
        def initial_pos = piece.pos_x
        piece.moveLeft()

        then:
        piece.pos_x == initial_pos - 1
    }
    def 'model.Piece Move Right'() {
        given:
        def piece = new Piece(5)

        when:
        def initial_pos = piece.pos_x
        piece.moveRight()

        then:
        piece.pos_x == initial_pos + 1
    }
    def 'model.Piece Move Down'() {
        given:
        def piece = new Piece(5)

        when:
        def initial_pos = piece.pos_y
        piece.forceDown()

        then:
        piece.pos_y == initial_pos + 1
    }

}
