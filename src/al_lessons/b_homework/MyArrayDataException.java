package al_lessons.b_homework;

public class MyArrayDataException extends Exception{

    private int firstIndex;
    private int secondIndex;

    public MyArrayDataException(int firstIndex, int secondIndex) {
        super(String.format("Введён некорректный символ в матрице. \n" +
                "Строка: %d. Столбец: %d. \n Введите число", (firstIndex + 1), (secondIndex + 1)));
        this.firstIndex = firstIndex;
        this.secondIndex = secondIndex;
    }

}
