package ru.geekbrains.java_two.lesson_fife.HomeWork_2_5;

class MiThread extends Thread {


    static final int size = 10000000;
    static final int h = size / 2;
    static float[] arr = new float[size];
    static float[] a1 = new float[h];
    static float[] a2 = new float[h];
    static Object monitor = new Object();

    public static void fillArrayByOne() {
        for (int i = 0; i < size; i++) {
            arr[i] = 1;
        }
    }


    public static long fillArrayByFirstType() {
        fillArrayByOne();

        long a = System.currentTimeMillis();

        fill(size, arr);

        long deltaTime = System.currentTimeMillis() - a;

        return deltaTime;
    }

    private synchronized static void fill(int size, float[] arr) {
        for (int i = 0; i < size; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
    }

    public static long fillArrayBySecondType() {
        fillArrayByOne();
        long a = System.currentTimeMillis();
        System.arraycopy(arr, 0, a1, 0, h);
        System.arraycopy(arr, h, a2, 0, h);
        synchronized (monitor) {
            fill(h, a1);
            System.arraycopy(a1, 0, arr, 0, h);
        }
        synchronized (monitor) {
            fill(h, a2);

            System.arraycopy(a2, 0, arr, h, h);
        }
        long e = System.currentTimeMillis() - a;

        return e;
    }

    public static long fillArrayByThirdTypeWithThread() {
        long f4 = System.currentTimeMillis();

        fillArrayByOne();
        long a = System.currentTimeMillis();
        System.arraycopy(arr, 0, a1, 0, h);
        System.arraycopy(arr, h, a2, 0, h);
        long f5 = System.currentTimeMillis() - f4;
        System.out.println("fillArray = " + f5);
        return f5;
    }

    public static long metod1() {
        long f2 = System.currentTimeMillis();
        fill(h, a1);
        System.arraycopy(a1, 0, arr, 0, h);
        long f3 = System.currentTimeMillis() - f2;
        System.out.println("metod1 = " + f3);
        return f3;
    }

    public static long metod2() {
        long f0 = System.currentTimeMillis();
        fill(h, a2);
        System.arraycopy(a2, 0, arr, h, h);
        long f1 = System.currentTimeMillis() - f0;
        System.out.println("metod2 = " + f1);
        return f1;
    }

    public static void main(String[] args) throws InterruptedException {

        System.out.println("время на заполнение массива первым способом " + fillArrayByFirstType() + " ms");
        System.out.println("время на заполнение массива вторым способом " + fillArrayBySecondType() + " ms");

        long e = System.currentTimeMillis();
        fillArrayByThirdTypeWithThread();
        Runnable q = new Runnable() {
            @Override
            public void run() {
                metod1();
//                metod2();
                System.out.println("Закончил 1");
            }
        };
        q.run();
        new Thread(q, "1").start();
//        new Thread(q,"2").start();


        Runnable q2 = new Runnable() {
            @Override
            public void run() {
                metod2();
                System.out.println("Закончил 2");
            }
        };
        q2.run();
        new Thread(q, "1").join();
        new Thread(q2, "2").start();
        new Thread(q2, "2").join();


//        System.out.println(System.currentTimeMillis() - e);


    }


}

