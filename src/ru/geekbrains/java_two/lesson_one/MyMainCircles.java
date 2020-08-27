package ru.geekbrains.java_two.lesson_one;

import javax.swing.*;
import java.awt.*;

public class MyMainCircles extends JFrame {

    private final int WIDTH = 800;
    private final int HEIGTH = 600;
    private final int POS_X = 400;
    private final int POS_Y = 200;
    Background back;
    int a = 10;
    MyBall[] ball = new MyBall[a];
    MyBall[] ballAdd;


    public static void main(String[] args) {
        new MyMainCircles();
    }

    public void addBall() {
        ballAdd = new MyBall[ball.length + 1];
        for (int i = 0; i < ball.length; i++) {
            ballAdd[i] = ball[i];
        }
        ballAdd[ball.length] = new MyBall();
        ball = ballAdd;
    }

    public MyMainCircles() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(POS_X, POS_Y, WIDTH, HEIGTH);
        MyCanvas canvas = new MyCanvas(this);
        add(canvas, BorderLayout.CENTER);
        setTitle("MyBalls");
        initAplication();
        setVisible(true);

    }

    public void initAplication() {
        for (int i = 0; i < a; i++) {
            ball[i] = new MyBall();

        }

    }

    public void onDrawFrame(MyCanvas canvas, Graphics g, float delteTime) {
        background(canvas);
        update(canvas, delteTime);
        render(canvas, g);
//        addBall(canvas);

    }

    private void render(MyCanvas canvas, Graphics g) {
        for (int i = 0; i < ball.length; i++) {
            ball[i].render(canvas, g);


        }
    }

    private void update(MyCanvas canvas, float deltaTime) {
        for (int i = 0; i < ball.length; i++) {
            ball[i].update(canvas, deltaTime);
        }
    }

    private void background(MyCanvas canvas) {
        back = new Background();
        canvas.setBackground(back.render());

    }

}
