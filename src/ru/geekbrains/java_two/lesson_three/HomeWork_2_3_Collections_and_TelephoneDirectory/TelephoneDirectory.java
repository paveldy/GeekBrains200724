package ru.geekbrains.java_two.lesson_three.HomeWork_2_3_Collections_and_TelephoneDirectory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class TelephoneDirectory {
//    long phoneNumber;
//    String name;
    HashMap<String, Long> map;
    HashMap<String, Long> getMap;

    ArrayList<HashMap<String, Long>> array = new ArrayList<>();
    ArrayList<HashMap<String, Long>> getArray;

    TelephoneDirectory() {
    }


    public void add(String name, long phoneNumber) {
        map = new HashMap<>();
        map.put(name, phoneNumber);
        array.add(map);
    }

    public void print() {
        System.out.println(array);
    }

    public void get(String name) {
        getArray = new ArrayList<>();
        getMap = new HashMap<>();
        for (int i = 0; i < array.size(); i++) {
            map = array.get(i);
            for (Map.Entry<String, Long> o : map.entrySet()) {
                if (name == o.getKey()) {
                    getMap.put(o.getKey(), o.getValue());
                    getArray.add(getMap);
                    getMap = new HashMap<>();
                }
            }
        }
        if (getArray.isEmpty()) {
            System.out.println("такого человека нет в базе");
        } else {
            for (int i = 0; i <getArray.size() ; i++) {
               map = getArray.get(i);
                for (Map.Entry<String, Long> o : map.entrySet()){
                    System.out.println(o.getKey() +" телефон: " +o.getValue() );
                }
            }
        }
    }

}




