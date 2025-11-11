import java.util.Arrays;

public class Sort01And012 {

    // Sort array containing only 0s and 1s
    public static void sort01(int[] arr) {
        int zeroIndex = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                swap(arr, i, zeroIndex);
                zeroIndex++;
            }
        }
    }

    // Sort array containing 0s, 1s, and 2s (Dutch National Flag)
    public static void sort012(int[] arr) {
        int low = 0, mid = 0, high = arr.length - 1;
        while (mid <= high) {
            switch (arr[mid]) {
                case 0:
                    swap(arr, low, mid);
                    low++;
                    mid++;
                    break;
                case 1:
                    mid++;
                    break;
                case 2:
                    swap(arr, mid, high);
                    high--;
                    break;
            }
        }
    }

    // Swap utility
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // Test
    public static void main(String[] args) {
        int[] arr01 = {0, 1, 0, 1, 0, 1};
        sort01(arr01);
        System.out.println("Sorted 0-1 Array: " + Arrays.toString(arr01));

        int[] arr012 = {0, 2, 1, 2, 0, 1, 0, 2};
        sort012(arr012);
        System.out.println("Sorted 0-1-2 Array: " + Arrays.toString(arr012));
    }
}
