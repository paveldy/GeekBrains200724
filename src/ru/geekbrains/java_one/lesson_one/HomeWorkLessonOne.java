package ru.geekbrains.java_one.lesson_one;

public class HomeWorkLessonOne {

    //    the first task
    public static double calculateExpression(int a, int b, int c, int d) {
        double resultOfExpression = a * (b + ((double)c / d));
        return resultOfExpression;
    }

    //  the second task
    private static boolean lieInInterval(int a, int b) {
        boolean resultOfMethod;
        if (a + b > 10 && a + b < 20) {
            resultOfMethod = true;
        } else {
            resultOfMethod = false;
        }

        return resultOfMethod;
    }

    //    the third task
    private static String polarity(int a) {
        String resultOfMethod = "";
        if (a < 0) {
            resultOfMethod = " is negativ";
        } else {
            resultOfMethod = " is positive";
        }

        return resultOfMethod;
    }

    //    the fourth task
    public static String hellofriend(String name) {
        return "Hello " + name;
    }

    //    the fifth task
    public static String year(int a) {
        String year = "";
        if (a % 100 == 0 || a % 4 != 0) {
            if (a % 400 == 0) {
                year = "високосный";
            } else {
                year = "невисокосный";
            }
        } else if (a % 4 == 0) {
            year = "високосный";
        }
        return year;
    }


    public static void main(String[] args) {
        int a = 2;
        int b = 5;
        int c = 7;
        int d = 11;
        int e = -11;
        String name = "Pablo";
        int year = 2104;

        System.out.println("to the first task");
        System.out.println(calculateExpression(a, b, c, d));

        System.out.println("to the second task");
        System.out.println(lieInInterval(c, d));

        System.out.println("to the third task");
        System.out.println("number " + e + polarity(e));

        System.out.println("to the fourth task");
        System.out.println(hellofriend(name));

        System.out.println("to the fifth task");
        System.out.println(year(year));


    }
}
