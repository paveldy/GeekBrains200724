package ru.geekbrains.java_one.lesson_four;

import java.util.Arrays;

public class Main {
    public static void print (Workers arr[]){
        for (int i = 0; i <arr.length ; i++) {
            System.out.println("ФИО " + arr[i].getName()+ "-" + " зарплата "+arr[i].getMoney());
        }

    }
    public static void increaseSalary(Workers arr[]){
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].getAge()>=45){
                arr[i].setMoney(arr[i].getMoney()+5000);
                System.out.println(arr[i].getName()+ " "+ arr[i].getMoney());
            }

        }
    }
    public static int average(Workers arr[]){
        int average =0;
        for (int i = 0; i < arr.length; i++) {
            average+=arr[i].getMoney();
        }
        return average/ arr.length;
    }
    public static int arithmeticalMean(Workers arr[]){
        int average =0;
        for (int i = 0; i < arr.length; i++) {
            average+=arr[i].getAge();
        }
        return average/ arr.length;
    }
    public static void printNameAndId(Workers arr[]){
        for (int i = 0; i <arr.length ; i++) {
            System.out.println("ФИО " + arr[i].getName() +" ID " + arr[i].ID);
        }
    }


    public static void main(String[] args) {
        Workers arr[] = new Workers[5];
        Workers one = new Workers("Voloda", 4000, 45,0);
        arr[0] = one;
        Workers two = new Workers("Sergey", 4000, 25,0);
        arr[1] = two;
        Workers three = new Workers("Pavel", 4000, 30,0);
        arr[2] = three;
        Workers four = new Workers("Dima", 4000, 20,0);
        arr[3] = four;
        Workers fife = new Workers("Karas", 4000, 70,0);
        arr[4] = fife;
        Workers six = new Workers("Petr", 6400, 45, 0);

        for (int i = 0; i < arr.length; i++) {
            if (arr[i].getAge() > 40) {
                System.out.println("Name is " + arr[i].getName() + ";" + " salary " + arr[i].getMoney() +";"+ " age is " + arr[i].getAge());
            }
        }

        print(arr);
        increaseSalary(arr);
        System.out.println("Average earnings = "+average(arr));
        System.out.println("Arithmetical mean age is "+ arithmeticalMean(arr));
        printNameAndId(arr);

    }
}
