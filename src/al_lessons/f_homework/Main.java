package al_lessons.f_homework;

public class Main {


    public static void main(String[] args) throws InterruptedException {

        System.out.println(checkArray(firstMethod(), secondMethod()));

    }

    public static float[] firstMethod() {

        final int size = 10000000;
        float[] arr = new float[size];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = 1;
        }

        long a = System.currentTimeMillis();

        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }

        System.out.println(System.currentTimeMillis() - a);

        return arr;

    }

    public static float[] secondMethod() throws InterruptedException {
        final int size = 10000000;
        final int h = size / 2;
        float[] arr = new float[size];

        float[] array1 = new float[h];
        float[] array2 = new float[h];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = 1;
        }

        long a = System.currentTimeMillis();

        System.arraycopy(arr, 0, array1, 0, h);
        System.arraycopy(arr, h, array2, 0, h);


        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread1 started");
                for (int i = 0; i < array1.length; i++) {
                    array1[i] = (float) (array1[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
                }
                System.out.println("Thread1 finished");
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread2 started");
                for (int i = 0; i < array2.length; i++) {
                    array2[i] =
                            (float) (array2[i] * Math.sin(0.2f + (i + h)/ 5) * Math.cos(0.2f + (i + h)/ 5) * Math.cos(0.4f + (i + h) / 2));
                }
                System.out.println("Thread2 finished");
            }
        });

        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();

        System.arraycopy(array1, 0, arr, 0, h);
        System.arraycopy(array2, 0, arr, h, h);

        System.out.println(System.currentTimeMillis() - a);

        return arr;
    }

    public static boolean checkArray(float[] arr1, float[] arr2) {
        for (int i = 0; i < arr1.length; i++) {
            if(arr1[i] != arr2[i])
                return false;
        }
        return true;
    }
}
