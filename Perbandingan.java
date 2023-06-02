import java.util.Arrays;
import java.util.Random;

public class Perbandingan {
    public static void main(String[] args) {
        int[] array = generateRandomArray(1000000); // Menghasilkan array dengan 1 juta angka random
        int target = 500000; // Angka yang akan dicari

        long startTime, endTime, linearSearchTime, binarySearchTime;

        // Linear Search
        startTime = System.nanoTime();
        linearSearch(array, target);
        endTime = System.nanoTime();
        linearSearchTime = endTime - startTime;

        // Binary Search
        int[] sortedArray = Arrays.copyOf(array, array.length);
        Arrays.sort(sortedArray); // Melakukan sort pada array
        startTime = System.nanoTime();
        binarySearch(sortedArray, target);
        endTime = System.nanoTime();
        binarySearchTime = endTime - startTime;

        // Perbandingan waktu
        System.out.println("Waktu yang dibutuhkan Linear Search: " + linearSearchTime + " nanosekon");
        System.out.println("Waktu yang dibutuhkan Binary Search: " + binarySearchTime + " nanosekon");
    }

    public static int[] generateRandomArray(int size) {
        int[] array = new int[size];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(size);
        }
        return array;
    }

    public static int linearSearch(int[] array, int target) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == target) {
                return i;
            }
        }
        return -1;
    }

    public static int binarySearch(int[] array, int target) {
        int left = 0;
        int right = array.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (array[mid] == target) {
                return mid;
            }

            if (array[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;
    }
}
