import spock.lang.Specification

class PieceRotationTest extends Specification{
    def 'JPiece Rotation'(){
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

    def 'LinePiece Rotation'(){
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

    def 'LPiece Rotation'(){
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

    def 'SPiece Rotation'(){
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

    def 'TPiece Rotation'(){
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

    def 'ZPiece Rotation'(){
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
