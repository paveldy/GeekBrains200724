package ru.geekbrains.java_three.lesson_fife.RaceRoad;

public abstract class Stage {
    protected int length;
    protected String description;

    public String getDescription() {
        return description;
    }

    public abstract void go(Car c);
}
