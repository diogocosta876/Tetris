import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.awt.event.KeyEvent;

public class keyController {
    private static volatile boolean leftPressed = false;
    private static volatile boolean rightPressed = false;
    private static volatile boolean upPressed = false;
    private static volatile boolean downPressed = false;
    private static volatile boolean escPressed = false;

    public static boolean isLeftPressed() {
        synchronized (keyController.class) {
            return leftPressed;
        }
    }
    public static boolean isRightPressed() {
        synchronized (keyController.class) {
            return rightPressed;
        }
    }
    public static boolean isUpPressed() {
        synchronized (keyController.class) {
            return upPressed;
        }
    }
    public static boolean isDownPressed() {
        synchronized (keyController.class) {
            return downPressed;
        }
    }
    public static boolean isEscPressed() {
        synchronized (keyController.class) {
            return escPressed;
        }
    }

    public static void controller_override() {
        KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(new KeyEventDispatcher() {
            @Override
            public boolean dispatchKeyEvent(KeyEvent mykey) {
                synchronized (keyController.class) {
                    switch (mykey.getID()) {
                        case KeyEvent.KEY_PRESSED:
                            if (mykey.getKeyCode() == KeyEvent.VK_LEFT) {
                                leftPressed = true;
                            }
                            else if (mykey.getKeyCode() == KeyEvent.VK_RIGHT) {
                                rightPressed = true;
                            }
                            else if (mykey.getKeyCode() == KeyEvent.VK_UP) {
                                upPressed = true;
                            }
                            else if (mykey.getKeyCode() == KeyEvent.VK_DOWN) {
                                downPressed = true;
                            }
                            else if (mykey.getKeyCode() == KeyEvent.VK_ESCAPE) {
                                escPressed = true;
                            }
                            break;

                        case KeyEvent.KEY_RELEASED:
                            if (mykey.getKeyCode() == KeyEvent.VK_LEFT) {
                                leftPressed = false;
                            }
                            else if (mykey.getKeyCode() == KeyEvent.VK_RIGHT) {
                                rightPressed = false;
                            }
                            else if (mykey.getKeyCode() == KeyEvent.VK_UP) {
                                upPressed = false;
                            }
                            else if (mykey.getKeyCode() == KeyEvent.VK_DOWN) {
                                downPressed = false;
                            }
                            else if (mykey.getKeyCode() == KeyEvent.VK_ESCAPE) {
                                escPressed = false;
                            }
                            break;
                    }
                    return false;
                }
            }
        });
    }
}