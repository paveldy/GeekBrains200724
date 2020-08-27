package ru.geekbrains.java_one.lesson_seven;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyExampleTicTac extends JFrame {
    private int WIN_WIDTH = 620;
    private int WIN_HEIGHT = 550;
    private int WIN_POSX = 500;
    private int WIN_POSY = 150;
    private Map map;
    private MySettingsWindow settings;

    MyExampleTicTac() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setSize(WIN_WIDTH, WIN_HEIGHT);
//        setLocation(WIN_POSX, WIN_POSY);
        setLocationRelativeTo(null);
        setTitle("My TicToe");
        map = new Map();
        JButton btnStartGame = new JButton("Start");
        JButton btnCancel = new JButton("Exit");
        settings = new MySettingsWindow(this);

        btnStartGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                settings.setVisible(true);

            }
        });
        btnCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
//        JPanel panelBott = new JPanel(new GridLayout(6, 1));
        JPanel panelBott = new JPanel();
        panelBott.setBackground(Color.RED);
//        Dimension preferredSize = new Dimension(100, 100); //  работает криво
//        panelBott.setPreferredSize(preferredSize);// работает криво
//        panelBott.setLayout(new FlowLayout(FlowLayout.CENTER));
        panelBott.add(btnStartGame);
        panelBott.add(btnCancel);
        add(panelBott, BorderLayout.SOUTH);
//        getContentPane().add(panelBott);  - тоже самое что и add(panelBott)
        add(map);
        setVisible(true);

    }


    void applySettings(int mode, int fieldSizeX, int fieldSizeY, int winLength) {
        map.startNewGame(mode, fieldSizeX, fieldSizeY, winLength);
    }

    public static void main(String[] args) {
        new MyExampleTicTac();
    }
}
