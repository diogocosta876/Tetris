package ldts;

import ldts.controller.MenuController;
import ldts.controller.keyController;

import java.io.IOException;

public class Application {
    public static void main(String[] args) throws IOException {
        keyController.controller_override();

        System.out.println("Hello World!");
        MenuController menu = new MenuController();
        menu.run();
    }
}
