package ru.geekbrains.java_two.lesson_two.HomeWork_2_2_Excep;

import java.util.Arrays;

public class HoweWork_2_2_Exception {

    public static String[][] stringMassive(String string) throws SizeOfLength {
        String[] str;
        str = string.split("\n");
        if (str.length != 4) throw new SizeOfLength();

        String[] str2;
        String[][] str3 = new String[4][4];
        int[][] integer = new int[4][4];
        int count = 0;
        for (int i = 0; i < integer.length; i++) {
            str2 = str[i].split(" ");
            if (str2.length != 4) throw new SizeOfLength();
            for (int j = 0; j < integer.length; j++) {
                str3[i][j] = str2[j];
            }
        }
        System.out.println("___________________________________");
        return str3;
    }

    public static int[][] integerMassiv(String[][] massive)  {
        int[][] inter = new int[4][4];

        for (int i = 0; i < massive.length; i++) {
            for (int j = 0; j < massive.length; j++) {
//                 if(inter[i][j] != Integer.parseInt(massive[i][j])) throw new Words();;
                try {
                    inter[i][j] = Integer.parseInt(massive[i][j]);
                } catch (NumberFormatException e) {
                    throw new Words();
                }
            }
        }
        System.out.println(Arrays.deepToString(inter));
        return inter;
    }

    public static int amountElements(int[][] massive) {
        int count = 0;
        for (int i = 0; i < massive.length; i++) {
            for (int j = 0; j < massive.length; j++) {
                count = count + massive[i][j];
            }
        }
        return count;
    }

    static class SizeOfLength extends Exception {
        public SizeOfLength() {
            super("Проверьте длину массива");
        }
    }

    static class Words extends NumberFormatException {
        public Words() {
            super("В массиве присутсвует слово");
        }
    }

    public static void main(String[] args) throws SizeOfLength, Words {
        String string = "10 3 1 2\n2 3 2 2\n5 6 7 1\n300 3 1 0";
        System.out.println("Сумма всех эелментов массива = " + amountElements(integerMassiv(stringMassive(string))));
    }
}
