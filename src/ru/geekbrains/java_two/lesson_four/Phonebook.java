package ru.geekbrains.java_two.lesson_four;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.stream.Collectors;

public class Phonebook {
    // РњРµС‚РѕРґ С†РµРїРѕС‡РµРє. Р’СЃСЏ РїРѕСЃР»РµРґСѓСЋС‰Р°СЏ СѓС‚РѕС‡РЅСЏСЋС‰Р°СЏ РёРЅС„РѕСЂРјР°С†РёСЏ
    // Р±СѓРґРµС‚ СЃСЂР°РІРЅРёРІР°С‚СЊСЃСЏ РЅР°РїСЂСЏРјСѓСЋ (РІРёР·СѓР°Р»СЊРЅРѕ, РёР»Рё РїСЂРѕРіСЂР°РјРјРЅРѕ)
    private final HashMap<String, ArrayList<Person>> entries = new HashMap<>();

    public void add(String name, String phone, String mail) {
        if (entries.containsKey(name)) {
            ArrayList<Person> persons = entries.get(name);
            persons.add(new Person(name, phone, mail));
        } else {
            ArrayList<Person> persons = new ArrayList<>();
            persons.add(new Person(name, phone, mail));
            entries.put(name, persons);
        }
    }

    public ArrayList<String> getMails(String name) {
        if (!entries.containsKey(name)) return null;
        // РѕРїС‚РёРјРёР·Р°С†РёСЏ, С‡С‚Рѕ С‚С‹ РґРµР»Р°РµС€СЊ, РїСЂРµРєСЂР°С‚Рё)))
        return entries.get(name).stream().map(person -> person.email)
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public ArrayList<String> getPhones(String name) {
        if (!entries.containsKey(name)) return null;
        ArrayList<Person> persons = entries.get(name);
        ArrayList<String> result = new ArrayList<>();
        for (int i = 0; i < persons.size(); i++) {
            result.add(persons.get(i).phone);
        }
        return result;
    }

}