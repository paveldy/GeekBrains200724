package ru.geekbrains.java_two.lesson_three.HomeWork_2_3_Collections_and_TelephoneDirectory;

import java.util.*;

public class HomeWork_2_3_Collections {

    private static Set<String> isUniqueWords(String[] str) {
        Set<String> set = new HashSet<>(Arrays.asList(str));
        return set;
    }

    public static HashMap<String, Integer> countRepitedWords(String[] str) {
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length; i++) {
            map.put(str[i], 0);
        }
        for (int i = 0; i < str.length; i++) {
            for (Map.Entry<String, Integer> o : map.entrySet()) {
                if (o.getKey() == str[i]) {
                    o.setValue(o.getValue() + 1);
                }
            }

        }
        return map;
    }

    public static void main(String[] args) {

        String[] str = new String[]{"Kolobok","Slovo","Kolobok","Lom", "Slovo", "Mama", " Stok", "Lom", "Brus", "Dab", "Box", "Lom"};
        System.out.println("Имеющиеся слова в строке :"+isUniqueWords(str));
        System.out.println("Слово = Кол-во повторений:" + countRepitedWords(str));



        TelephoneDirectory data = new TelephoneDirectory();
        data.add("Vasiliy", 9111502526l);
        data.add("Sergey", 9811502526l);
        data.add("Vasiliy", 9211502526l);
        data.add("Vasiliy", 3211502526l);
        data.add("Sergey", 1931502526l);
        data.add("Pavel", 5421502526l);
        data.add("Alex", 2221502526l);

        data.print(); // печатает всю базу
        data.get("Vasiliy"); // выдаёт телефоны по заданному имени

        System.out.println("________________________________________________________");
        System.out.println("Второй вариант");
        Telefon noviy = new Telefon();
        noviy.add(9111502526l,"Vasiliy");
        noviy.add(5611502526l,"Pavel");
        noviy.add(3111502526l,"Vasiliy");
        noviy.add(4789502526l,"Sergey");
        noviy.add(3111502526l,"Slava");
        noviy.add(838502526l,"Pavel");

        noviy.get();
        noviy.print("Slava");

    }
}
