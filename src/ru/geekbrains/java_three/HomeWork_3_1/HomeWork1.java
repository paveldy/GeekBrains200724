package ru.geekbrains.java_three.HomeWork_3_1;

import java.util.ArrayList;
import java.util.Arrays;

public class HomeWork1 {
    // the first task
    public static Object[] changePlace(Object[] massiv, int firtsPosition, int secondPosition) {
        Object tmp;
        tmp = massiv[firtsPosition];
        massiv[firtsPosition] = massiv[secondPosition];
        massiv[secondPosition] = tmp;
        return massiv;
    }

    // the second task
    public static ArrayList<Object> massifToArray(Object[] massiv) {
        ArrayList<Object> array = new ArrayList<>();
        for (int i = 0; i < massiv.length; i++) {
            array.add(massiv[i]);
        }
        return array;
    }

    public static void main(String[] args) {
        String[] strings = {"1", "2", "3", "4"};
        // to the first task
        System.out.println(Arrays.toString((changePlace(strings, 2, 3))));
        // to the second task
        System.out.println(massifToArray(strings).toString());

    }
}
