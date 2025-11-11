
public class QuickSelect {

    // Find the k-th smallest element (1-based index)
    public static int quickSelect(int[] arr, int k) {
        if (k < 1 || k > arr.length) throw new IllegalArgumentException("k is out of bounds");
        return quickSelectHelper(arr, 0, arr.length - 1, k - 1); // 0-based index
    }

    private static int quickSelectHelper(int[] arr, int low, int high, int k) {
        if (low == high) return arr[low];

        int pivotIndex = partition(arr, low, high);

        if (k == pivotIndex) {
            return arr[k];
        } else if (k < pivotIndex) {
            return quickSelectHelper(arr, low, pivotIndex - 1, k);
        } else {
            return quickSelectHelper(arr, pivotIndex + 1, high, k);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return i + 1;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {7, 10, 4, 3, 20, 15};
        int k = 3; // 3rd smallest element

        int kthSmallest = quickSelect(arr, k);
        System.out.println(k + "-th smallest element is: " + kthSmallest);
    }
}
