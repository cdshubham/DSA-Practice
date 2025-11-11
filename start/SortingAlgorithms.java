
public class SortingAlgorithms {

    // Bubble Sort
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    // Selection Sort
    public static void selectionSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }

    // Insertion Sort
    public static void insertionSort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }

    // Merge Sort
    public static void mergeSort(int[] arr) {
        if (arr.length < 2) return;
        mergeSortHelper(arr, 0, arr.length - 1);
    }

    private static void mergeSortHelper(int[] arr, int left, int right) {
        if (left >= right) return;
        int mid = left + (right - left) / 2;
        mergeSortHelper(arr, left, mid);
        mergeSortHelper(arr, mid + 1, right);
        merge(arr, left, mid, right);
    }

    private static void merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] L = new int[n1];
        int[] R = new int[n2];

        System.arraycopy(arr, left, L, 0, n1);
        System.arraycopy(arr, mid + 1, R, 0, n2);

        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) arr[k++] = L[i++];
            else arr[k++] = R[j++];
        }
        while (i < n1) arr[k++] = L[i++];
        while (j < n2) arr[k++] = R[j++];
    }

    // Quick Sort
    public static void quickSort(int[] arr) {
        quickSortHelper(arr, 0, arr.length - 1);
    }

    private static void quickSortHelper(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSortHelper(arr, low, pi - 1);
            quickSortHelper(arr, pi + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }

    // Counting Sort
    public static void countingSort(int[] arr) {
        if (arr.length == 0) return;

        // Find min and max
        int min = arr[0], max = arr[0];
        for (int num : arr) {
            if (num < min) min = num;
            if (num > max) max = num;
        }

        int range = max - min + 1;
        int[] count = new int[range];

        // Count occurrences
        for (int num : arr) {
            count[num - min]++;
        }

        // Reconstruct sorted array
        int index = 0;
        for (int i = 0; i < range; i++) {
            while (count[i] > 0) {
                arr[index++] = i + min;
                count[i]--;
            }
        }
    }

    // Utility method to print array
    public static void printArray(int[] arr) {
        for (int num : arr) System.out.print(num + " ");
        System.out.println();
    }

    // Test all sorting algorithms
    public static void main(String[] args) {
        int[] arr = {5, 2, 9, 1, 5, 6};

        int[] bubbleArr = arr.clone();
        bubbleSort(bubbleArr);
        System.out.print("Bubble Sort: ");
        printArray(bubbleArr);

        int[] selectionArr = arr.clone();
        selectionSort(selectionArr);
        System.out.print("Selection Sort: ");
        printArray(selectionArr);

        int[] insertionArr = arr.clone();
        insertionSort(insertionArr);
        System.out.print("Insertion Sort: ");
        printArray(insertionArr);

        int[] mergeArr = arr.clone();
        mergeSort(mergeArr);
        System.out.print("Merge Sort: ");
        printArray(mergeArr);

        int[] quickArr = arr.clone();
        quickSort(quickArr);
        System.out.print("Quick Sort: ");
        printArray(quickArr);

        int[] countArr = arr.clone();
        countingSort(countArr);
        System.out.print("Counting Sort: ");
        printArray(countArr);
    }
}
