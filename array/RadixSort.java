import java.util.Arrays;

public class RadixSort {

    // Main radix sort method
    public static void radixSort(int[] arr) {
        if (arr.length == 0) return;

        // Find the maximum number to know the number of digits
        int max = Arrays.stream(arr).max().getAsInt();

        // Do counting sort for every digit (exp = 1, 10, 100, ...)
        for (int exp = 1; max / exp > 0; exp *= 10) {
            countingSortByDigit(arr, exp);
        }
    }

    // Counting sort according to the digit represented by exp
    private static void countingSortByDigit(int[] arr, int exp) {
        int n = arr.length;
        int[] output = new int[n];
        int[] count = new int[10]; // digits 0-9

        // Count occurrences of digits
        for (int i = 0; i < n; i++) {
            int digit = (arr[i] / exp) % 10;
            count[digit]++;
        }

        // Change count[i] so that it contains actual position
        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        // Build output array (stable)
        for (int i = n - 1; i >= 0; i--) {
            int digit = (arr[i] / exp) % 10;
            output[count[digit] - 1] = arr[i];
            count[digit]--;
        }

        // Copy output to original array
        System.arraycopy(output, 0, arr, 0, n);
    }

    // Test
    public static void main(String[] args) {
        int[] arr = {170, 45, 75, 90, 802, 24, 2, 66};
        System.out.println("Original Array: " + Arrays.toString(arr));

        radixSort(arr);
        System.out.println("Sorted Array:   " + Arrays.toString(arr));
    }
}
