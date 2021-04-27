package al_lessons.b_homework;

public class MyArraySizeException extends Exception {

    private int matrixColumns;
    private int matrixStrings;


    public MyArraySizeException(String message, int matrixColumns, int matrixStrings) {
        super(message);
        this.matrixColumns = matrixColumns;
        this.matrixStrings = matrixStrings;
    }
}
