package ru.geekbrains.java_two.lesson_two.blesson.online;

public interface Human extends Animal {
    int a = 10;
    void talk();
    default void walk() {
        System.out.println("walks on two legs" + a);
    }
}
