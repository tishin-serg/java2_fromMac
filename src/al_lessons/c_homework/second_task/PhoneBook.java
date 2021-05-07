package al_lessons.c_homework.second_task;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class PhoneBook {

    static Map<String, ArrayList<String>> phoneBook = new HashMap<>();

    public static void add(String surname, String phone) {

        if (phoneBook.containsKey(surname)) {               // если в мапе уже есть такой ключ
            phoneBook.get(surname).add(phone);              // то добавить в существующий лист по ключу значение
        } else {
            ArrayList<String> phones = new ArrayList<>(); // в остальных случаях если такого ключа нет, то создаем новый лист
            phones.add(phone);                            // добавляем в лист значение
            phoneBook.put(surname, phones);               // кладём в мапу по ключу этот лист
        }

    }

    public static ArrayList<String> get(String surname) {
        return phoneBook.get(surname);
    }

    public static void main(String[] args) {
        add("Ivanov", "8-996-666-44-55");
        add("Petrov", "8-910-555-66-33");
        add("Sidorov", "8-955-111-22-00");
        add("Toporov", "8-960-100-20-30");
        add("Ivanov", "8-953-450-66-48");
        add("Sidorov", "8-990-158-44-22");

        System.out.println(get("Ivanov"));
        System.out.println(get("Toporov"));
        System.out.println(get("Sidorov"));

    }

}
