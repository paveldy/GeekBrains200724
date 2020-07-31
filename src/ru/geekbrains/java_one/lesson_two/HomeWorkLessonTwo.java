package ru.geekbrains.java_one.lesson_two;

import java.util.Arrays;

public class HomeWorkLessonTwo {

    //one task
    private static void changeOnetoZero(int[] massiv) {
        for (int i = 0; i < massiv.length; i++) {
            if (massiv[i] == 1) {
                massiv[i] = 0;
            } else if (massiv[i] == 0) {
                massiv[i] = 1;
            }

        }
    }

    //    two task
    private static void fillMassive(int[] massiv1) {
        massiv1[0] = 1;
        for (int i = 1; i < massiv1.length; i++) {
            massiv1[i] = massiv1[i - 1] + 3;
        }
    }

    //     third task
    private static void lessThanSixIncriaseOnTwo(int[] massiv2) {
        for (int i = 0; i < massiv2.length; i++) {
            if (massiv2[i] < 6) {
                massiv2[i] = massiv2[i] * 2;
            }
        }
    }

    //      the fourth task
    private static int getMax(int[] massiv2) {
        int max = massiv2[0];
        for (int i = 0; i < massiv2.length; i++) {
            if (massiv2[i] > max) {
                max = massiv2[i];
            }
        }
        return max;
    }


    private static int getMin(int[] massiv2) {
        int min = massiv2[0];
        for (int i = 0; i < massiv2.length; i++) {
            if (massiv2[i] < min) {
                min = massiv2[i];
            }
        }
        return min;
    }

    private static void fillDiagonalByOne(int[][] massiv3) {
        for (int i = 0; i < massiv3.length; i++) {
            for (int j = 0; j < massiv3.length; j++) {
                if (i == j || j == massiv3.length - i - 1) {
                    massiv3[i][j] = 1;
                }
            }
        }
    }

    private static boolean rightSumEqualsLeftSum(int[] massiv4) {
        int sumRight = 0;
        int sumLeft = 0;
        boolean sum = false;
        for (int i = 0; i < massiv4.length; i++) {
            sumRight = sumRight + massiv4[i];
            for (int j = 0; j < massiv4.length - i; j++) {
                sumLeft = sumLeft + massiv4[massiv4.length - 1 - j];
                if (sumRight == sumLeft) {
                    sum = true;
                }
            }
            sumLeft = 0;

        }
        return sum;
    }

    //    int[] massiv4 = {1, 3, 4, 5, 6, 7, 3, 3};
    public static void changePosition(int[] a, int n) {
        System.out.println(Arrays.toString(a));
        if (n >= 0) {
            for (int i = 0; i < n; i++) {
                int tmp;
                tmp = a[0];
                for (int j = 0; j < a.length - 1; j++) {
                    a[j] = a[j + 1];
                }
                a[a.length - 1] = tmp;
            }
            System.out.println(Arrays.toString(a));
        } else if (n<0){
            int m=-n;
            for (int i = 0; i < m; i++) {
                int tmp;
                tmp = a[a.length-1];
                for (int j = 0; j < a.length - 1; j++) {
                    a[a.length-1-j] = a[a.length-2-j];
                }
                a[0] = tmp;
            }
            System.out.println(Arrays.toString(a));
        }
    }
    public static void main(String[] args) {
        //    the first task
        int massiv[] = {1, 0, 1, 0, 0, 0, 1, 1, 0, 1, 1, 1, 0, 0,};
        changeOnetoZero(massiv);

        //    the second task
        int massiv1[] = new int[8];
        fillMassive(massiv1);

        //        the third task
        int massiv2[] = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        lessThanSixIncriaseOnTwo(massiv2);

        //        the fourth task - обращаю внимание, что massiv2 к данному моменту у нас изменился.
        int min = getMin(massiv2);
        int max = getMax(massiv2);

        //        the fifth task
        int[][] massiv3 = new int[5][5];
        fillDiagonalByOne(massiv3);
        System.out.println(Arrays.deepToString(massiv3));
        //        the sixth task
        int[] massiv4 = {1, 3, 4, 5, 6, 7, 3, 3};
        rightSumEqualsLeftSum(massiv4);
        System.out.println(rightSumEqualsLeftSum(massiv4));

        //        the seventh task
        changePosition(massiv4, -4);
    }
}

