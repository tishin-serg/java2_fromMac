package al_lessons.b_homework;

public class Main {

    static String[][] stringMatrix = {{"1", "2", "3", "4"},
                                    {"5", "6", "7", "8"},
                                    {"9", "10", "11", "12"},
                                     {"13", "14", "15", "16"}};
    static int[][] intMatrix;
    static int sum = 0;

    public static void main(String[] args) {

        try {
            intMatrix = convertToIntMatrix(stringMatrix);
            if (checkMatrixSize(stringMatrix) | checkDataArray(stringMatrix)) {System.out.println(sum);}
        } catch (MyArrayDataException | MyArraySizeException e) {
            e.printStackTrace();
        }

    }

    private static int[][] convertToIntMatrix(String[][] matrix) {

        int[][] intMatrix = new int[matrix.length][];

        for (int i = 0; i < matrix.length; i++) {
            String[] arrayStrings = matrix[i];
            int[] arrayInt = new int[arrayStrings.length];
            for (int j = 0; j < arrayStrings.length; j++) {
                arrayInt[j] = convertToInt(arrayStrings[j]);
            }
            intMatrix[i] = arrayInt;
        }

        for (int[] x : intMatrix) {
            for (int y : x) {
                sum += y;
            }
        }
            return intMatrix;
    }

    private static int convertToInt(String str) {
        return Integer.parseInt(str);
    }

    private static boolean checkMatrixSize(String[][] matrix) throws MyArraySizeException {

        for (String[] strings : matrix) {
            if (strings.length != 4) {
                throw new MyArraySizeException("Требуется матрица размером: 4х4. Проверьте количество элементов"
                        , strings.length, matrix.length);
            } else if (matrix.length != 4) {
                throw new MyArraySizeException("Требуется матрица размером: 4х4. Проверьте количество элементов"
                        , strings.length, matrix.length);
            }
        }
        return true;
    }

    private static boolean checkDataArray(String[][] matrix) throws MyArrayDataException {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (!matrix[i][j].matches("\\d+")) {
                    throw new MyArrayDataException(i, j);
                }
            }
        }
        return true;
    }


}

