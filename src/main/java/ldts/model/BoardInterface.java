package ldts.model;

public interface BoardInterface {
    int getLength();
    int getWidth();
    String[][] getMatrix();

    void addPiece(Piece piece);
    boolean canMove(int nextPosX, Piece piece);//CHECKS IF PIECE ISNT MOVINTO ONTO ANOTHER PIECE
    boolean hasHitBottom(Piece piece);//CHECKS IF PIECE HAS HIT THE BOTTOM OR A BOTTOM PIECE
    int checkLineCompletition(GenericRemoveLine remover);
}
