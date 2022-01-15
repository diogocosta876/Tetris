package ldts.model;

public class Score {
    private int score;

    public Score(){score=0;}

    public void addToScore(int linesCompleted) {
        score += 10*linesCompleted;
    }

    public int getScore(){
        return this.score;
    }
}
