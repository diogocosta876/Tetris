import java.io.IOException;

public class Application {
    public static void main(String[] args) throws IOException {
        keyController.controller_override();

        System.out.println("Hello World!");
        Game game = new Game();
        game.run();
    }
}
