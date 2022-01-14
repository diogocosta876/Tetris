package ldts.model;

public class Score {
    private int score;

    public Score(){score=0;}

    public void addToScore(int linesCompleted) {
        this.score += linesCompleted*10;
    }

    public int getScore(){
        return this.score;
    }
}
