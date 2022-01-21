import ldts.model.Board

import ldts.model.Piece
import ldts.model.PieceStates.LPiece
import ldts.model.PieceStates.LinePiece
import ldts.model.PieceStates.SquarePiece
import ldts.model.RemoveLine
import spock.lang.Specification

class BoardTest extends Specification {
    def 'Add piece Test'(){
        given:
        def piece = new Piece(2)
        def state = new SquarePiece()
        piece.setState(state)
        def board = new Board(12,2)

        def c = state.color
        def b = "#000000"

        when:
        piece.pos_x = 2
        piece.pos_y = 0
        board.addPiece(piece)

        then:
        String[][] matrix = [
                [b,b,c,c,b,b],
                [b,b,c,c,b,b],
        ]
        board.getMatrix() == matrix
    }

    def 'Can Move Test'(){
        given:
        def piece1 = new Piece(0)
        def state1 = new LPiece()
        piece1.setState(state1)
        piece1.pos_x = 0
        piece1.pos_y = 0

        def piece2 = new Piece(2)
        def state2 = new SquarePiece()
        piece2.setState(state2)
        piece2.pos_x = 2
        piece2.pos_y = 0


        //matrix = [
        //  [c,b,P,P,b,b],
        //  [c,b,P,P,b,b],
        //  [c,c,b,b,b,b]
        // ];

        when:
        def board = new Board(12,3)
        board.addPiece(piece1)

        then:
        board.canMove(piece2.pos_x-1,piece2) == true

        when:
        piece2.pos_x-=1

        then:
        board.canMove(piece2.pos_x-1,piece2) == false


    }

    def 'Has Hit Bottom Test'(){
        given:
        def piece1 = new Piece(0)
        def state1 = new LPiece()
        piece1.setState(state1)
        piece1.pos_x = 0
        piece1.pos_y = 0

        def piece2 = new Piece(2)
        def state2 = new LinePiece()
        piece2.setState(state2)
        piece2.pos_x = 2
        piece2.pos_y = 0

        //matrix = [
        //  [c,b,P,P,P,P],
        //  [c,b,b,b,b,b],
        //  [c,c,b,b,b,b]
        // ];

        def board = new Board(12,3)
        board.addPiece(piece1)

        when:
        def result = board.hasHitBottom(piece2)
        then:
        result == false

        when:
        piece2.pos_x-=1
        then:
        board.hasHitBottom(piece2)== false

        when:
        piece2.pos_y+=1
        then:
        board.hasHitBottom(piece2)== true

        when:
        piece2.pos_y+=1
        piece2.pos_x+=1
        then:
        board.hasHitBottom(piece2)== true


    }

    def 'Can Rotate Test'(){
        given:
        def piece1 = new Piece(0)
        def state1 = new LPiece()
        piece1.setState(state1)
        piece1.pos_x = 0
        piece1.pos_y = 0

        def piece2 = new Piece(2)
        def state2 = new LinePiece()
        piece2.setState(state2)
        piece2.pos_x = 1
        piece2.pos_y = 1

        //matrix = [
        //  [c,b,b,b,b,b],
        //  [c,P,P,P,P,b],
        //  [c,c,b,b,b,b]
        // ];

        def board = new Board(12,3)
        board.addPiece(piece1)

        when:
        def result = board.canRotate(piece2)
        then:
        result == false

    }

    def 'Can Rotate Test 2'(){
        given:
        def piece2 = new Piece(2)
        def state2 = new LinePiece()
        piece2.setState(state2)
        piece2.pos_x = 1
        piece2.pos_y = 2

        //matrix = [
        //  [b,b,b,b,b,b],
        //  [b,b,b,b,b,b],
        //  [b,P,P,P,P,b],
        // ];

        def board = new Board(12,3)

        when:
        def result = board.canRotate(piece2)
        then:
        result == false

    }

    def 'Check Line Completition'(){ //Without mock
        given:
        def state1 = new LPiece()
        def state2 = new LinePiece()

        def b = "#000000"
        def c = state1.color
        def P = state2.color


        def board = new Board(12,4)
        board.setMatrix([
                  [c,b,b,b,b,b],
                  [c,c,c,c,c,c],
                  [c,b,b,c,b,b],
                  [c,c,P,P,P,P],
                 ] as String[][])


        when:
        def result = board.checkLineCompletition(new RemoveLine())

        then:
        result  == 2
        board.getMatrix()==[
                [b,b,b,b,b,b],
                [b,b,b,b,b,b],
                [c,b,b,b,b,b],
                [c,b,b,c,b,b],
        ] as String[][]

    }

    def 'Check Line Completition with RemoveLine Mock'(){
        given:
        def state1 = new LPiece()
        def state2 = new LinePiece()

        def b = "#000000"
        def c = state1.color
        def P = state2.color

        def remover = Mock(RemoveLine)
        remover.removeLine(1,_ as String[][]) >> ([
                [b,b,b,b,b,b],
                [c,b,b,b,b,b],
                [c,b,b,c,b,b],
                [c,c,P,P,P,P],
        ] as String[][])
        remover.removeLine(3,_ as String[][]) >> ([
                [b,b,b,b,b,b],
                [b,b,b,b,b,b],
                [c,b,b,b,b,b],
                [c,b,b,c,b,b],
        ] as String[][])

        def board = new Board(12,4)
        board.setMatrix([
                [c,b,b,b,b,b],
                [c,c,c,c,c,c],
                [c,b,b,c,b,b],
                [c,c,P,P,P,P],
        ] as String[][])


        when:
        board.checkLineCompletition(remover)

        then:
        board.getMatrix()==[
                [b,b,b,b,b,b],
                [b,b,b,b,b,b],
                [c,b,b,b,b,b],
                [c,b,b,c,b,b],
        ] as String[][]

    }

    def 'Game Over Test'(){
        given:
        def state1 = new LPiece()

        def b = "#000000"
        def c = state1.color


        def board = new Board(12,4)
        board.setMatrix([
                [c,b,b,b,b,b],
                [c,c,c,c,c,c],
        ] as String[][])


        when:
        def result = board.gameOver()

        then:
        result  == true
    }
}
