package ru.geekbrains.java_two.lesson_fife.HomeWork_2_5;

class MyThread extends Thread {

    public MyThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        System.out.println("Thread started");


    }
//        System.out.println("Thread stopped");
}



