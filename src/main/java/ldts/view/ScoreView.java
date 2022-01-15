package ldts.view;

import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import ldts.model.Score;

public class ScoreView extends View<Score>{

    private int score;

    public ScoreView(Score model){
        this.model = model;
        this.score = model.getScore();
    }

    public void update(){
        this.score = model.getScore();
    }

    public void draw(TextGraphics screenGraphics){
        update();
        screenGraphics.setBackgroundColor(TextColor.Factory.fromString("#3A3A3A"));
        screenGraphics.putString(42, 18, "  ___  ___ ___  ___ ___");
        screenGraphics.putString(42, 19, " / __|/ __/ _ \\| _ \\ __|");
        screenGraphics.putString(42, 20, " \\__ \\ (_| (_) |   / _|");
        screenGraphics.putString(42, 21, " |___/\\___\\___/|_|_\\___|");
        screenGraphics.putString(52, 24,Integer.toString(score), SGR.BOLD);
    }
}
