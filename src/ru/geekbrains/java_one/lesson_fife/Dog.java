package ru.geekbrains.java_one.lesson_fife;

public class Dog extends Animals{
    int swimMax;
    public Dog(String name, int age, String color, int runMax, double jumpMax, int swimMax){
        super(name, age, color, runMax, jumpMax);
        this.swimMax = swimMax;

    }

    @Override
    public void swim(int length) {
        int maxLength = this.swimMax;
        if (maxLength<length){
            System.out.println(this.name+" can't swim at this distance");
        }
        else {
            System.out.println(this.name+" swim "+ length);
        }
    }
}
