package ru.geekbrains.java_one.lesson_fife;


public class Cat extends Animals {
    public Cat(String name, int age, String color, int runMax, double jumpMax){
        super(name, age, color,runMax,jumpMax);
    }

    @Override
    public void swim(int length){
        System.out.println("Cats can't swim");
    }
}
