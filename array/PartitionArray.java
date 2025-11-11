import java.util.Arrays;

public class PartitionArray {

    // Partition array around pivot (last element)
    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[high]; // choose last element as pivot
        int i = low - 1; // index of smaller element

        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return i + 1; // pivot index after partition
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {9, 3, 4, 2, 8, 5};
        int pivotIndex = partition(arr, 0, arr.length - 1);

        System.out.println("Partitioned Array: " + Arrays.toString(arr));
        System.out.println("Pivot is at index: " + pivotIndex);
        System.out.println("Pivot value: " + arr[pivotIndex]);
    }
}
