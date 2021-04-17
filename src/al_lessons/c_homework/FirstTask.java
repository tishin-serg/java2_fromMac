package al_lessons.c_homework;

import java.util.HashMap;
import java.util.Map;

public class FirstTask {

    static String[] words = {"orange", "apple", "banana", "cherry", "cucumber", "apple",
            "apricot", "cherry", "tomato", "potato", "potato", "orange", "orange", "cucumber"};


    public static void main(String[] args) {

        printUnique(words);
        System.out.println();
        countOfDoubles(words); // в принципе, этот метод выполняет обе задачи, но в условии говорилось справиться с первой с помощью массива

    }

    public static void printUnique(String[] array) {


        for (int i = 0; i < array.length; i++) {

            String word = array[i];

            boolean isNotUnique = false;

            for (int j = i + 1; j < array.length; j++) { // бежим по массиву так, чтобы значение i и j не совпало

                if (word.equals(array[j])) {
                    isNotUnique = true;                 // если строка не уникальная, ставим флаг true
                    break;
                }
            }
            if (!isNotUnique) {                          // если строка уникальна, то печатаем в консоль и добавляем в лист уникальных строк
                System.out.println(word);
            }
        }

    }


    public static void countOfDoubles(String[] array) {

        Map<String, Integer> map = new HashMap<>();


        for (String word : array) {
            int count = 0;
            for (String s : array) {
                if (word.equals(s)) {
                    count++;
                }
            }
            map.put(word, count);
        }

        for (Map.Entry<String, Integer> item : map.entrySet()) {
            System.out.printf("Количество совпадений слова '%s' в массиве = %d \n", item.getKey(), item.getValue());
        }

    }


}
