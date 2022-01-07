import ldts.model.Piece
import ldts.model.PieceStates.*
import spock.lang.Specification

class PieceRotationTest extends Specification{
    def 'model.pieces.JPiece Rotation'(){
        given:
        def piece = new Piece(10);
        def state = new JPiece();
        piece.setState(state);
        def c = state.getColor();
        def b = "#000000";

        when:
        piece.rotate();

        then:
        String[][] matrix = [
                [c,b,b],
                [c,c,c]];

        piece.getMatrix() == matrix;
    }

    def 'model.pieces.LinePiece Rotation'(){
        given:
        def piece = new Piece(10);
        def state = new LinePiece();
        piece.setState(state);
        def c = state.color;
        def b = "#000000";

        when:
        piece.rotate();

        then:
        String[][] matrix = [
                [c],
                [c],
                [c],
                [c]
        ];

        piece.getMatrix() == matrix;
    }

    def 'model.pieces.LPiece Rotation'(){
        given:
        def piece = new Piece(10);
        def state = new LPiece();
        piece.setState(state);
        def c = state.color;
        def b = "#000000";

        when:
        piece.rotate();

        then:
        String[][] matrix = [
                [c,c,c],
                [c,b,b]];

        piece.getMatrix() == matrix;
    }

    def 'model.pieces.SPiece Rotation'(){
        given:
        def piece = new Piece(10);
        def state = new SPiece();
        piece.setState(state);
        def c = state.color;
        def b = "#000000";

        when:
        piece.rotate();

        then:
        String[][] matrix = [
                [c,b],
                [c,c],
                [b,c]
        ];

        piece.getMatrix() == matrix;
    }

    def 'model.pieces.TPiece Rotation'(){
        given:
        def piece = new Piece(10);
        def state = new TPiece();
        piece.setState(state);
        def c = state.color;
        def b = "#000000";

        when:
        piece.rotate();

        then:
        String[][] matrix = [
                [c,b],
                [c,c],
                [c,b]
        ];

        piece.getMatrix() == matrix;
    }

    def 'model.pieces.ZPiece Rotation'(){
        given:
        def piece = new Piece(10);
        def state = new ZPiece();
        piece.setState(state);
        def c = state.color;
        def b = "#000000";

        when:
        piece.rotate();

        then:
        String[][] matrix = [
                [b,c],
                [c,c],
                [c,b]
        ];

        piece.getMatrix() == matrix;
    }
}
