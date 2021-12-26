public class Application {
    public static void main(String[] args) {
        keyController.controller_override();

        System.out.println("Hello World!");
        Game game = new Game();
        game.run();
    }
}
