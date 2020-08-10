package ru.geekbrains.java_one.lesson_fife;

public abstract class Animals {

    protected String name;
    protected int age;
    protected String color;
    protected int runMax;
    protected double jumpMax;

    protected Animals() {

    }

    protected Animals(String name, int age, String color, int runMax, double jumpMax) {
        this.name = name;
        this.age = age;
        this.color = color;
        this.runMax = runMax;
        this.jumpMax = jumpMax;
    }


    public void jump(double height) {
        double maxHeight = this.jumpMax;
        if (maxHeight>height){
            System.out.println(this.name+" can't jump at this distance");
        }
        else {
            System.out.println(this.name+" jump "+ height);
        }
    }


    public void swim(int length) {

    }

    public void run(int distance) {
        int maxDistance = this.runMax;
        if (distance > runMax) {
            System.out.println(this.name + " can't run at this distance");
        } else {
            System.out.println(this.name + " run " + distance);
        }
    }
}