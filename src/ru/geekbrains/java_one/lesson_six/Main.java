package ru.geekbrains.java_one.lesson_six;


import java.io.*;
import java.util.Scanner;

public class Main {

    private static void method1() {
        try {
            throw new IOException("This is our Exception");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void method2() throws IOException {
        throw new IOException("This is an exception");
    }

    private static int div(int a, int b) {
        return a / b;
    }

    public static void main(String[] args) {
        InputStream in;
        OutputStream out;

        try {
//            FileOutputStream fos = new FileOutputStream("test.txt", true);
//            fos.write("HelloWorld!".getBytes());
//            fos.flush();
//            fos.close();

//            PrintStream ps = new PrintStream(new FileOutputStream("test.txt", true));
//            ps.println("Hello, World!");
//            ps.flush();
//            ps.close();

//            FileInputStream fis = new FileInputStream("test.txt");
//            int b;
//            while ( (b = fis.read()) != -1 )
//                System.out.print((char) b);

            Scanner scanner = new Scanner(new FileInputStream("test.txt"));
            while (scanner.hasNext())
                System.out.println(scanner.nextLine());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    private static void stringBuilderExample() {
        long startTime = System.nanoTime();
        // do something useful
        String s = "Example";
        for (int i = 0; i < 100_000; i++) {
            s += i;
        }
        float deltaTime = (System.nanoTime() - startTime) * 0.000001f;
        System.out.println(deltaTime + " millisec");

        startTime = System.nanoTime();
        StringBuilder sb = new StringBuilder("Example");
        for (int i = 0; i < 100_000; i++) {
            sb.append(i);
        }
        deltaTime = (System.nanoTime() - startTime) * 0.000001f;
        System.out.println(deltaTime + " millisec");


        System.out.println(s.equals(sb.toString()));
    }

    private static void stringExample() {
        Scanner scanner = new Scanner(System.in);
        String st0 = "hello";
        String st1 = new String("hello");
        String st2 = "he";
        String st3 = st2 + "llo";
        String st4 = scanner.next();

        System.out.println(st0.equals(st1));
        System.out.println(st0.equals(st3));
        System.out.println(st0.equals(st4));
    }
}