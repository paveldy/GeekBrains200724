package ru.geekbrains.java_three.HomeWork_3_1;

import java.util.ArrayList;

public class Box2 {
    public static ArrayList<Fruit> list = new ArrayList<>();
//    public int quantityBoxOfApple;
//    public int quantityBoxOfOrange;
    public int quantityFruitIntoBox = 20;
    public int weigth;

    public Box2() {
    }

    public void addFruitToBox(Fruit a) {
        list.add(a);
    }

    public float getWeigth(Fruit a) {
        weigth = 0;
        if (a instanceof Apple) {
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i) instanceof Apple) {
                    weigth += list.get(i).b*Apple.weigthApple;
                }
            }
        } else if (a instanceof Orange) {
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i) instanceof Orange) {
                    weigth += list.get(i).b*Orange.weigthOrang;
                }
            }
        }
        return weigth;
    }

    public static void main(String[] args) {
        Box2 box2 = new Box2();
        Apple ap1 = new Apple(10);
        box2.addFruitToBox(ap1);
        Apple ap2 = new Apple(15);
        box2.addFruitToBox(ap2);
        Apple ap3 = new Apple(20);
        box2.addFruitToBox(ap3);
        Orange or1 = new Orange(2);
        box2.addFruitToBox(or1);
        Orange or2 = new Orange(11);
        box2.addFruitToBox(or2);
        Orange or3 = new Orange(8);
        box2.addFruitToBox(or3);

        System.out.println(box2.getWeigth(ap1));
        System.out.println(box2.getWeigth(or2));

    }

}








