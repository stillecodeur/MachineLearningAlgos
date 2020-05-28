package statistics;

import java.text.DecimalFormat;

public abstract class StatUtils {


    public static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        long factor = (long) Math.pow(10, places);
        value = value * factor;
        long tmp = Math.round(value);
        return (double) tmp / factor;
    }

    public static double mean(int[] numbers, int n) {
        double sum = 0;
        for (int i = 0; i < numbers.length; i++) {
            sum = sum + numbers[i];
        }
        return sum / n;
    }

    public static double median(double[] numbers, int n) {
        boolean isLengthEven = false;
        double median = 0;
        if (n % 2 == 0) {
            isLengthEven = true;
        }

        if (isLengthEven) {
            int mid1 = n / 2;
            int mid2 = mid1 - 1;
            median = (numbers[mid1] + numbers[mid2]) / 2;
        } else {
            int mid = (int) Math.ceil(n / 2);
            median = numbers[mid];
        }

        return median;
    }

    public static double median(int[] numbers, int n) {
        boolean isLengthEven = false;
        double median = 0;
        if (n % 2 == 0) {
            isLengthEven = true;
        }

        if (isLengthEven) {
            int mid1 = n / 2;
            int mid2 = mid1 - 1;
            median = (numbers[mid1] + numbers[mid2]) / 2;
        } else {
            int mid = (int) Math.ceil(n / 2);
            median = numbers[mid];
        }

        return median;
    }

    public static void sortArray(double[] array) {

        double temp = 0;
        for (int i = 0; i < array.length; i++) {
            double minElement = array[i];
            int minElementPosition = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < minElement) {
                    minElement = array[j];
                    minElementPosition = j;
                }
            }

            temp = array[i];
            array[i] = minElement;
            array[minElementPosition] = temp;
        }
    }

    public static void sortArray(int[] array) {

        int temp = 0;
        for (int i = 0; i < array.length; i++) {
            int minElement = array[i];
            int minElementPosition = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < minElement) {
                    minElement = array[j];
                    minElementPosition = j;
                }
            }

            temp = array[i];
            array[i] = minElement;
            array[minElementPosition] = temp;
        }
    }


    public static double mode(double[] array) {
        int[] occArr = new int[array.length];
        int maxCount = 1;
        double mode = array[0];

        for (int i = 0; i < array.length; i++) {
            double element = array[i];
            int count = 0;
            for (int j = 0; j < array.length; j++) {
                double elementToBeMatch = array[j];
                if (element == elementToBeMatch) {
                    count++;
                }
            }

            if (count > maxCount) {
                maxCount = count;
                mode = array[i];
            }
        }

        return mode;
    }

    public static boolean isOdd(int number) {
        return number % 2 != 0;
    }

    public static double median(int[] numbers, int lowerIndex, int higherIndex) {
        boolean isLengthEven = false;
        double median = 0;
        int n = (higherIndex + 1) - lowerIndex;
        if (n % 2 == 0) {
            isLengthEven = true;
        }

        if (isLengthEven) {
            int mid2 = n / 2;
            int mid1 = mid2 - 1;
            median = (numbers[lowerIndex + mid1] + numbers[lowerIndex + mid2]) / 2;
        } else {
            int mid = (int) Math.ceil(n / 2);
            median = numbers[lowerIndex + mid];
        }

        return median;
    }

}
