package ru.geekbrains.java_two.lesson_two.blesson.games.common;

import java.awt.*;

public interface CanvasListener {
    void onDrawFrame(GameCanvas canvas, Graphics g, float deltaTime);
}
