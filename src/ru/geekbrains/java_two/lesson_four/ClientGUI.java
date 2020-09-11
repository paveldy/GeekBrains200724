package ru.geekbrains.java_two.lesson_four;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.Scanner;

public class ClientGUI extends JFrame implements ActionListener, Thread.UncaughtExceptionHandler {

    private static final int WIDTH = 400;
    private static final int HEIGHT = 300;

    private final JTextArea log = new JTextArea();

    private final JPanel panelTop = new JPanel(new GridLayout(2, 3));
    private final JTextField tfIPAddress = new JTextField("127.0.0.1");
    private final JTextField tfPort = new JTextField("8189");
    private final JCheckBox cbAlwaysOnTop = new JCheckBox("Always on top");
    private final JTextField tfLogin = new JTextField("ivan");
    private final JPasswordField tfPassword = new JPasswordField("123");
    private final JButton btnLogin = new JButton("Login");

    private final JPanel panelBottom = new JPanel(new BorderLayout());
    private final JButton btnDisconnect = new JButton("<html><b>Disconnect</b></html>");
    private final JTextField tfMessage = new JTextField();
    private final JButton btnSend = new JButton("Send");
    private PrintWriter outMSg;
    String sendMsg;

    private final JList<String> userList = new JList<>();

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() { // Event Dispatching Thread
                new ClientGUI();
            }
        });
    }

    private ClientGUI() {
        Thread.setDefaultUncaughtExceptionHandler(this);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(WIDTH, HEIGHT);
        JScrollPane scrollUser = new JScrollPane(userList);
        JScrollPane scrollLog = new JScrollPane(log);
        String[] users = {"user1", "user2", "user3", "user4", "user5",
                "user_with_an_exceptionally_long_name_in_this_chat"};
        userList.setListData(users);
        scrollUser.setPreferredSize(new Dimension(100, 0));
        cbAlwaysOnTop.addActionListener(this);

        tfMessage.grabFocus();

// ловим нажатие кнопки SEND
        btnSend.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!tfMessage.getText().isEmpty()) {
                    sentMessage();
                }
                tfMessage.grabFocus();
            }
        }); // addActionListner
// ловим нажатие ENTERA (через окно сообщений)
        tfMessage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!tfMessage.getText().isEmpty()) {
                    sentMessage();
                }
                tfMessage.grabFocus();
            }
        });
// второй способ отлавливания ENTERA
//        tfMessage.addKeyListener(new KeyListener() {
//            @Override
//            public void keyTyped(KeyEvent e) {
//            }
//            @Override
//            public void keyPressed(KeyEvent e) {
//            }
//            @Override
//            public void keyReleased(KeyEvent e) {
//                if (e.getKeyCode()==KeyEvent.VK_ENTER) {
//                    if (!tfMessage.getText().isEmpty()) {
//                        sentMessage();
//                    }
//                }
//            }
//        });

        panelTop.add(tfIPAddress);
        panelTop.add(tfPort);
        panelTop.add(cbAlwaysOnTop);
        panelTop.add(tfLogin);
        panelTop.add(tfPassword);
        panelTop.add(btnLogin);
        panelBottom.add(btnDisconnect, BorderLayout.WEST);
        panelBottom.add(tfMessage, BorderLayout.CENTER);
        panelBottom.add(btnSend, BorderLayout.EAST);

        add(scrollLog, BorderLayout.CENTER);
        add(scrollUser, BorderLayout.EAST);
        add(panelTop, BorderLayout.NORTH);
        add(panelBottom, BorderLayout.SOUTH);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();
        if (src == cbAlwaysOnTop) {
            setAlwaysOnTop(cbAlwaysOnTop.isSelected());

        } else {
            throw new RuntimeException("Unknown source: " + src);
        }
    }

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        e.printStackTrace();
        String msg;
        StackTraceElement[] ste = e.getStackTrace();
        msg = "Exception in " + t.getName() + " " +
                e.getClass().getCanonicalName() + ": " +
                e.getMessage() + "\n\t at " + ste[0];
        JOptionPane.showMessageDialog(this, msg, "Exception", JOptionPane.ERROR_MESSAGE);
        System.exit(1);
    }

    public void sentMessage() {
        try {
            String sendMsg = tfMessage.getText();
            inputStream();
            log.setText(sendMsg);// не уверен
            // здесь отправляю сообщение в метод для записи в файл
            // думаю лучше сделать в чат сервере
            outputStream(sendMsg);

            tfMessage.setText("");
//            outMSg.flush();


        } catch (NullPointerException | IOException e) {


        }
    }

    public void outputStream(String sendMsg) throws IOException {
        FileOutputStream fos = new FileOutputStream("log.txt", true);
        fos.write('\n');
        fos.write(sendMsg.getBytes());
        fos.flush();
        fos.close();


    }

    // вынимаю сообщения из файла на печать в лог
    // раотает не правильно...
    public void inputStream() throws FileNotFoundException {
        Scanner scanner = new Scanner(new FileInputStream("log.txt"));
        while (scanner.hasNext()) {
            log.setText(scanner.nextLine());

        }
        scanner.close();

    }

}