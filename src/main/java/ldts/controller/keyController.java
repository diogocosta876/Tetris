package ldts.controller;

import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.awt.event.KeyEvent;

public class keyController {
    private static volatile boolean leftPressed = false;
    private static volatile boolean rightPressed = false;
    private static volatile boolean upPressed = false;
    private static volatile boolean downPressed = false;
    private static volatile boolean escPressed = false;
    private static volatile boolean zeroPressed = false;
    private static volatile boolean onePressed = false;
    private static volatile boolean twoPressed = false;
    private static volatile boolean threePressed = false;

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
    public static boolean isZeroPressed() {
        synchronized (keyController.class) {
            return zeroPressed;
        }
    }
    public static boolean isOnePressed() {
        synchronized (keyController.class) {
            return onePressed;
        }
    }
    public static boolean isTwoPressed() {
        synchronized (keyController.class) {
            return twoPressed;
        }
    }
    public static boolean isThreePressed() {
        synchronized (keyController.class) {
            return threePressed;
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
                            else if (mykey.getKeyCode() == KeyEvent.VK_0) {
                                zeroPressed = true;
                            }
                            else if (mykey.getKeyCode() == KeyEvent.VK_1) {
                                onePressed = true;
                            }
                            else if (mykey.getKeyCode() == KeyEvent.VK_2) {
                                twoPressed = true;
                            }
                            else if (mykey.getKeyCode() == KeyEvent.VK_3) {
                                threePressed = true;
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
                            else if (mykey.getKeyCode() == KeyEvent.VK_0) {
                                zeroPressed = false;
                            }
                            else if (mykey.getKeyCode() == KeyEvent.VK_1) {
                                onePressed = false;
                            }
                            else if (mykey.getKeyCode() == KeyEvent.VK_2) {
                                twoPressed = false;
                            }
                            else if (mykey.getKeyCode() == KeyEvent.VK_3) {
                                threePressed = false;
                            }
                            break;
                    }
                    return false;
                }
            }
        });
    }
}