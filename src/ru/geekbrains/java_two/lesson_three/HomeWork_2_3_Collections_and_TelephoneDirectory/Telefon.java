package ru.geekbrains.java_two.lesson_three.HomeWork_2_3_Collections_and_TelephoneDirectory;

import java.util.HashMap;
import java.util.Map;

public class Telefon {

    HashMap<Long, String> mapa = new HashMap<>();

    public Telefon() {

    }
//        noviy.add(9111502526l,"Vasiliy");
//        noviy.add(5611502526l,"Pavel");
//        noviy.add(3111502526l,"Vasiliy");
//        noviy.add(4789502526l,"Sergey");
//        noviy.add(3111502526l,"Slava");

    public void add(long phone, String name) {

        for (Map.Entry<Long, String> m : mapa.entrySet()) {
            if (mapa.isEmpty()) {
                mapa.put(phone, name);
            }
            if (phone == m.getKey()) {
                System.out.println("такой "+phone+ " есть в базе c именим: " + m.getValue());
                mapa.put(m.getKey(),m.getValue());

            }
//            не понял почему VALUE 17 строки (см. выше) перезаписывает VALUE 15 строки,
//            которая была добавлена раньше данным методом.
        }
        mapa.put(phone, name);

    }

    public void get() {
        for (Map.Entry<Long, String> o : mapa.entrySet()) {
            System.out.println(o.getKey() + " " + o.getValue());
        }
    }
    public void print(String name) {
        for (Map.Entry<Long, String> o : mapa.entrySet()) {
            if (o.getValue() == name) {
                System.out.println("По вашему запросу есть: "+o.getValue() + " " + o.getKey());
            }

//            IF ELSE ИСПОЛЬЗОВАТЬ НЕЛЬЗЯ ВО ВРЕМЯ РАБОТЫ ИНТЕРАТОРА...ВЫДАЕТ ЕРУНДУ ИЛИ EXCEPTION
//            ТОЛЬКО IF
        }
        System.out.println("соответсвий вашему запросу больше нет");
    }


}
