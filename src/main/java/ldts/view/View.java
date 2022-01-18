package ldts.view;

import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;

public abstract class View<T> {

    protected T model;
    private Screen screen;
    protected TextGraphics graphics;

    protected View() {
    }
}