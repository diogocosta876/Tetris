package ldts.model;

public class LowDifficultyOrder implements Order{

    private Game game;
    public LowDifficultyOrder(Game gm){game = gm;}

    @Override
    public void execute() {
        game.decreaseGameSpeed();
    }

}