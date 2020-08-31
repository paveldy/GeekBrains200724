package ru.geekbrains.java_two.lesson_two.blesson.games.bricks;

import ru.geekbrains.java_two.lesson_two.blesson.games.common.CanvasListener;
import ru.geekbrains.java_two.lesson_two.blesson.games.common.GameCanvas;
import ru.geekbrains.java_two.lesson_two.blesson.games.common.GameObject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MainBricks extends JFrame implements CanvasListener {
    private static final int POS_X = 400;
    private static final int POS_Y = 200;
    private static final int WINDOW_WIDTH = 800;
    private static final int WINDOW_HEIGHT = 600;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainBricks();
            }
        });
    }

    private GameObject[] gameObjects = new GameObject[1];
    private int gameObjectsCount;

    private MainBricks() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(POS_X, POS_Y, WINDOW_WIDTH, WINDOW_HEIGHT);
        GameCanvas canvas = new GameCanvas(this);

        canvas.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                if (e.getButton() == MouseEvent.BUTTON1)
                    addGameObject(new Brick(e.getX(), e.getY()));
                else if (e.getButton() == MouseEvent.BUTTON3)
                    removeGameObject();
            }
        });

        add(canvas, BorderLayout.CENTER);
        initApplication();
        setTitle("Circles");
        setVisible(true);
    }

    private void addGameObject(GameObject s) {
        if (gameObjectsCount == gameObjects.length) {
            GameObject[] temp = new GameObject[gameObjects.length * 2];
            System.arraycopy(gameObjects, 0, temp, 0, gameObjects.length);
            gameObjects = temp;
        }
        gameObjects[gameObjectsCount++] = s;
    }

    private void removeGameObject() {
        if (gameObjectsCount > 1) gameObjectsCount--;
    }

    private void initApplication() {
    }

    @Override
    public void onDrawFrame(GameCanvas canvas, Graphics g, float deltaTime) {
        update(canvas, deltaTime);
        render(canvas, g);
    }

    private void update(GameCanvas canvas, float deltaTime) {
        for (int i = 0; i < gameObjectsCount; i++) {
            gameObjects[i].update(canvas, deltaTime);
        }
    }

    private void render(GameCanvas canvas, Graphics g) {
        for (int i = 0; i < gameObjectsCount; i++) {
            gameObjects[i].render(canvas, g);
        }
    }
}
