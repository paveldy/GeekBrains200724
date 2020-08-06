package ru.geekbrains.java_one.lesson_four;

public class Workers {
    private String name;
    private int money;
    private int age;
    public static int count =1;
    public int ID=0;

    Workers(){

    }


    Workers(String name, int money, int age, int ID){

        this.name=name;
        this.money=money;
        this.age = age;
        this.ID=count++;

    }
    public String getName(){
        return name;
    }
    public int getMoney(){
        return money;
    }
    public int getAge(){
        return age;
    }
    public void setName(String name){
        this.name = name;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public void setAge(int age) {
        this.age = age;
    }
}



