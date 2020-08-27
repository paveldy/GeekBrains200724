package ru.geekbrains.java_one.lesson_seven;

import javax.swing.*;
import java.awt.*;

public class MyFrameForChecking extends JFrame {
    MyFrameForChecking() {
        setTitle("I want to check myself");
        setSize(600, 500);
//        setLocation(400,300); - верхний левый угол - начало всего окна
        setLocationRelativeTo(null); // по умолчанию будет прям в центре экрана
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBackground(Color.BLUE);  // не работает

        JPanel panelButton = new JPanel();
        panelButton.setBackground(Color.RED); // работает с FlowLayout
        GridLayout quantityOfButtonOnPanel = new GridLayout(2,1);
        panelButton.setLayout(quantityOfButtonOnPanel);
        JButton start = new JButton("НАЧАЛО");
        JButton end = new JButton("ВЫХОД");


//        panelButton.add(start, new FlowLayout(FlowLayout.CENTER));
        panelButton.add(start);
        panelButton.add(end);

        add(panelButton, BorderLayout.WEST);
        setVisible(true);

    }

    public static void main(String[] args) {
        new MyFrameForChecking();
    }
}
