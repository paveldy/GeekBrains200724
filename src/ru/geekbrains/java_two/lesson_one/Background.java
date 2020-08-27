package ru.geekbrains.java_two.lesson_one;

import javax.swing.*;
import java.awt.*;

public class Background extends JPanel {

    Color color;

    public Background() {

    }

    public Color render() {


        color = new Color(
                (int) (Math.random() * 255),
                (int) (Math.random() * 255),
                (int) (Math.random() * 255));
        return color;
    }



}
