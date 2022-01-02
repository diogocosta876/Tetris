package ldts;

import ldts.controller.GameController;
import ldts.controller.keyController;
import ldts.model.Game;

import java.io.IOException;

public class Application {
    public static void main(String[] args) throws IOException {
        keyController.controller_override();

        System.out.println("Hello World!");
        GameController game = new GameController();
        game.run();
    }
}
