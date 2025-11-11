class MaxHeap {
    private int[] heap;
    private int size;

    // Constructor: build heap in linear time from an array
    public MaxHeap(int[] arr) {
        this.size = arr.length;
        this.heap = new int[size];
        System.arraycopy(arr, 0, heap, 0, size);

        // Build heap using heapify from last non-leaf node
        for (int i = parent(size - 1); i >= 0; i--) {
            heapifyDown(i);
        }
    }

    private int parent(int i) {
        return (i - 1) / 2;
    }

    private int leftChild(int i) {
        return 2 * i + 1;
    }

    private int rightChild(int i) {
        return 2 * i + 2;
    }

    // Heapify down (used in build-heap and extract)
    private void heapifyDown(int i) {
        int largest = i;
        int left = leftChild(i);
        int right = rightChild(i);

        if (left < size && heap[left] > heap[largest]) {
            largest = left;
        }
        if (right < size && heap[right] > heap[largest]) {
            largest = right;
        }

        if (largest != i) {
            swap(i, largest);
            heapifyDown(largest);
        }
    }

    // Heapify up (used in insert)
    private void heapifyUp(int i) {
        int current = i;
        while (current > 0 && heap[current] > heap[parent(current)]) {
            swap(current, parent(current));
            current = parent(current);
        }
    }

    private void swap(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    // Insert a new element
    public void insert(int val) {
        if (size == heap.length) {
            // Optional: resize array
            int[] newHeap = new int[size * 2];
            System.arraycopy(heap, 0, newHeap, 0, size);
            heap = newHeap;
        }
        heap[size] = val;
        heapifyUp(size);
        size++;
    }

    // Extract max element
    public int extractMax() {
        if (size == 0) throw new IllegalStateException("Heap is empty");
        int max = heap[0];
        heap[0] = heap[size - 1];
        size--;
        heapifyDown(0);
        return max;
    }

    public void printHeap() {
        for (int i = 0; i < size; i++) {
            System.out.print(heap[i] + " ");
        }
        System.out.println();
    }
}



public class HeapImplementation {
    public static void main(String[] args) {
        int[] arr = {3, 5, 1, 10, 2, 7};
        MaxHeap maxHeap = new MaxHeap(arr);

        System.out.println("Heap after build in linear time:");
        maxHeap.printHeap(); // Heapified array

        maxHeap.insert(12);
        System.out.println("After inserting 12:");
        maxHeap.printHeap();

        System.out.println("Extract Max: " + maxHeap.extractMax());
        System.out.println("Heap after extraction:");
        maxHeap.printHeap();
    }
}
