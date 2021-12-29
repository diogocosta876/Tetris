import ldts.model.pieces.JPiece
import ldts.model.pieces.LPiece
import ldts.model.pieces.LinePiece
import ldts.model.pieces.SPiece
import ldts.model.pieces.TPiece
import ldts.model.pieces.ZPiece
import spock.lang.Specification

class PieceRotationTest extends Specification{
    def 'model.pieces.JPiece Rotation'(){
        given:
        def piece = new JPiece();
        def c = piece.color;
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
        def piece = new LinePiece();
        def c = piece.color;
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
        def piece = new LPiece();
        def c = piece.color;
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
        def piece = new SPiece();
        def c = piece.color;
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
        def piece = new TPiece();
        def c = piece.color;
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
        def piece = new ZPiece();
        def c = piece.color;
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
