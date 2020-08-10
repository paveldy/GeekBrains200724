package ru.geekbrains.java_one.lesson_fife;

public class Main {
    public static void main(String[] args) {


        Cat cat0 = new Cat("Barsik",5,"White",200,2.5);
        Cat cat1 = new Cat("Filya", 8, "Grey", 250, 3);
        Dog dog0 = new Dog("Bob", 12, "Black", 500, 0.5, 10);
        Dog dog1 = new Dog("Kalibri", 8, "White", 450, 1, 20);

        cat0.swim(150);
        cat0.run(350);
        cat0.jump(2.5);
        dog1.swim(5);
        dog0.jump(1);

    }
}
