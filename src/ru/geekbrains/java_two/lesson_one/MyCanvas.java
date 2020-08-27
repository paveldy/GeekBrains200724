package ru.geekbrains.java_two.lesson_one;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MyCanvas extends JPanel {
    private float lastFrameTime;
    private MyMainCircles controller;
    //    public Background back;
    public float delta;
    public int a;

    MyCanvas(MyMainCircles controller) {
        this.controller = controller;

        addMouseListener(new MouseAdapter() {

            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);
                if (e.getButton() == MouseEvent.BUTTON1) {
                    controller.addBall();
                }else if (e.getButton() == MouseEvent.BUTTON3) {
                    controller.removeBall();
                }
            }

        });
        lastFrameTime = System.nanoTime();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        long currentTime = System.nanoTime();
        float deltaTime = (currentTime - lastFrameTime) * 0.000000001f;
        controller.onDrawFrame(this, g, deltaTime);
        lastFrameTime = currentTime;
        delta = deltaTime;
        try {
            Thread.sleep(17);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        repaint();
    }

    public int getLeft() {
        return 0;
    }

    public int getRight() {
        return getWidth() - 1;
    }

    public int getTop() {
        return 0;
    }

    public int getBottom() {
        return getHeight() - 1;
    }


}
