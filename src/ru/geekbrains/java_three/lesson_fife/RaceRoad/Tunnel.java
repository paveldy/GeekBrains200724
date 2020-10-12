package ru.geekbrains.java_three.lesson_fife.RaceRoad;

import java.util.concurrent.Semaphore;

import static ru.geekbrains.java_three.lesson_fife.RaceRoad.MainClass.HALF_CARS;

public class Tunnel extends Stage {

    Semaphore semaphore = new Semaphore(HALF_CARS);

    public Tunnel() {
        this.length = 80;
        this.description = "Тоннель " + length + " метров";
    }

    @Override
    public void go(Car c) {
        try {
            try {
                System.out.println(c.getName() + " готовится к этапу(ждет): " + description);
                semaphore.acquire();
                System.out.println(c.getName() + " начал этап: " + description);
                Thread.sleep(length / c.getSpeed() * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println(c.getName() + " закончил этап: " + description);
                semaphore.release();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
