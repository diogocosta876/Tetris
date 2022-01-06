package ldts.model;

public interface BoardInterface {
    int getLength();
    int getWidth();
    String[][] getMatrix();
    void addPiece(Piece piece);

    boolean canMove(int nextPosX, Piece piece);
    boolean hasHitBottom(Piece piece);
    int checkLineCompletition();

}
