package com.isatimur.pobot;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;

/**
 * Hello world!
 */
public class App {
    int sX = -1, sY = -1;
    boolean dragging = false;
    int curX = -1, curY = -1;
    Robot robot = new Robot();

    public static void main(String[] args) throws AWTException {
        new App();
    }

    public App() throws AWTException {
        robot.setAutoDelay(40);
        robot.setAutoWaitForIdle(true);

        robot.delay(4000);
        robot.mouseMove(2100, 550);
        robot.mousePress(InputEvent.BUTTON1_MASK);
        robot.delay(500);
        robot.mouseMove(2700, 550);
        robot.delay(1000);
        robot.mouseRelease(InputEvent.BUTTON1_MASK);

//        leftClick();
//        robot.delay(500);
//        leftClick();
//
//        robot.delay(500);
//        type("Hello, world");
//
//        robot.mouseMove(40, 160);
//        robot.delay(500);
//
//        leftClick();
//        robot.delay(500);
//        leftClick();
//
//        robot.delay(500);
//        type("This is a test of the Java Robot class");
//
//        robot.delay(50);
//        type(KeyEvent.VK_DOWN);
//
//        robot.delay(250);
//        type("Four score and seven years ago, our fathers ...");
//
//        robot.delay(1000);
//        System.exit(0);

    }

    private void leftClick() {
        robot.mousePress(InputEvent.BUTTON1_MASK);
        robot.delay(200);
        robot.mouseRelease(InputEvent.BUTTON1_MASK);
        robot.delay(200);
    }

    private void type(int i) {
        robot.delay(40);
        robot.keyPress(i);
        robot.keyRelease(i);
    }

    private void type(String s) {
        byte[] bytes = s.getBytes();
        for (byte b : bytes) {
            int code = b;
            // keycode only handles [A-Z] (which is ASCII decimal [65-90])
            if (code > 96 && code < 123)
                code = code - 32;
            robot.delay(40);
            robot.keyPress(code);
            robot.delay(4000);
            robot.keyRelease(code);
        }
    }

}
