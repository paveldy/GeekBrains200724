package ru.geekbrains.java_one.lesson_six;

import java.io.*;
import java.util.Scanner;

public class MainIO {
    //

    public static void main(String[] args) throws IOException {
        FileOutputStream fos3 = new FileOutputStream("test3.txt", true);
        Scanner sc1 = new Scanner(new FileInputStream("test.txt"));

        while (sc1.hasNext()) {
            fos3.write(sc1.nextLine().getBytes());
        }

        sc1.close();
        Scanner sc2 = new Scanner(new FileInputStream("test2.txt"));

        while (sc2.hasNext()) {
            fos3.write(sc2.nextLine().getBytes());
        }

        sc2.close();
        Scanner sc3 = new Scanner(new FileInputStream("test3.txt"));

        while (sc3.hasNext()) {
            if (sc3.nextLine().contains("Dzhek")) {
                System.out.println("yes, file contains this word");
            }
        }

        sc3.close();
        fos3.close();
        Files();
    }

    public static void Files() {
        File dir = new File("C://Users//pavel//IdeaProjects//GeekBrains200724");
        if (dir.isDirectory()) {
            File[] var1 = dir.listFiles();
            int var2 = var1.length;

            for (int var3 = 0; var3 < var2; ++var3) {
                File item = var1[var3];
                System.out.println(item.getName());

                try {
                    Scanner sc4 = new Scanner(new FileInputStream(item.getName()));

                    while (sc4.hasNext()) {
                        if (sc4.nextLine().contains("Dzhek")) {
                            System.out.println("yes, file contains this word");
                        }
                    }

                    sc4.close();
                } catch (FileNotFoundException var6) {
                }
            }
        }

    }
}



