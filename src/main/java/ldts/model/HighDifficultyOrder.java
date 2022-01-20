package ldts.model;

public class HighDifficultyOrder implements Order{

    private Game game;
    public HighDifficultyOrder(Game gm){game = gm;}

    @Override
    public void execute() {
        game.increaseGameSpeed();
    }

}