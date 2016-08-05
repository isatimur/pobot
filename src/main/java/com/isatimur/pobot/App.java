package com.isatimur.pobot;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.image.BufferedImage;
import java.io.*;

/**
 * Hello world!
 */
public class App {
    public static final int _X_START_SCREEN = 550;
    public static final int _Y_HEIGHT_SCREEN = 900;
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
        robot.delay(1500);

        while (true) {

            for (int i = 0; i < 4; i++) {

                if (i == 0) {
                    robot.delay(500);
                    robot.mouseMove(_X_START_SCREEN + 105, 702);
                    robot.mousePress(InputEvent.BUTTON1_MASK);
                    robot.delay(500);
                    robot.mouseRelease(InputEvent.BUTTON1_MASK);

                }
                if (i == 1) {
                    robot.mouseMove(_X_START_SCREEN + 180, 533);
                    robot.mousePress(InputEvent.BUTTON1_MASK);
                    robot.delay(500);
                    robot.mouseRelease(InputEvent.BUTTON1_MASK);

                }

                if (i == 2) {
                    robot.mouseMove(_X_START_SCREEN + 216, 472);
                    robot.mousePress(InputEvent.BUTTON1_MASK);
                    robot.delay(500);
                    robot.mouseRelease(InputEvent.BUTTON1_MASK);

                }

                if (i == 3) {
                    robot.mouseMove(_X_START_SCREEN + 354, 594);
                    robot.mousePress(InputEvent.BUTTON1_MASK);
                    robot.delay(500);
                    robot.mouseRelease(InputEvent.BUTTON1_MASK);

                }
                robot.delay(1000);

//        }

//SWIPE at pokestop
                robot.delay(1000);
                robot.mouseMove(575, 450);
                robot.mousePress(InputEvent.BUTTON1_MASK);
                robot.delay(500);
                robot.mouseMove(775, 450);
                robot.delay(1000);
                robot.mouseRelease(InputEvent.BUTTON1_MASK);

//click to close window of pokestop

                robot.delay(1000);
                robot.mouseMove(780, 835);
                robot.delay(1000);
                robot.mousePress(InputEvent.BUTTON1_MASK);
                robot.delay(200);
                robot.mouseRelease(InputEvent.BUTTON1_MASK);
                robot.delay(1000);

                // make a screen shot just for history
                robot.delay(1000);
                Rectangle rectScreenSize = new Rectangle(_X_START_SCREEN, 0, 500, _Y_HEIGHT_SCREEN);
                BufferedImage biScreen;
                biScreen = robot.createScreenCapture(rectScreenSize);
                OutputStream os = null;
                try {
                    os = new FileOutputStream(new File("screen" + System.currentTimeMillis() + ".png"));
                    ImageIO.write(biScreen, "png", os);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                robot.delay(500);
            }

//wait for next operation        
            robot.delay(60000);
            robot.delay(60000);
            robot.delay(60000);
            robot.delay(60000);
            robot.delay(60000);
        }


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
