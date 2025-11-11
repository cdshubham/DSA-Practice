import java.util.Iterator;
import java.util.NoSuchElementException;

public class GenericHeap<T extends Comparable<T>> implements Iterable<T> {
    private T[] heap;
    private int size;

    @SuppressWarnings("unchecked")
    public GenericHeap(int capacity) {
        heap = (T[]) new Comparable[capacity];
        size = 0;
    }

    @SuppressWarnings("unchecked")
    public GenericHeap(T[] arr) {
        size = arr.length;
        heap = (T[]) new Comparable[size];
        System.arraycopy(arr, 0, heap, 0, size);

        // Build heap in linear time
        for (int i = parent(size - 1); i >= 0; i--) {
            heapifyDown(i);
        }
    }

    private int parent(int i) { return (i - 1) / 2; }
    private int leftChild(int i) { return 2 * i + 1; }
    private int rightChild(int i) { return 2 * i + 2; }

    private void swap(int i, int j) {
        T temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    private void heapifyDown(int i) {
        int largest = i;
        int left = leftChild(i);
        int right = rightChild(i);

        if (left < size && heap[left].compareTo(heap[largest]) > 0)
            largest = left;
        if (right < size && heap[right].compareTo(heap[largest]) > 0)
            largest = right;

        if (largest != i) {
            swap(i, largest);
            heapifyDown(largest);
        }
    }

    private void heapifyUp(int i) {
        int current = i;
        while (current > 0 && heap[current].compareTo(heap[parent(current)]) > 0) {
            swap(current, parent(current));
            current = parent(current);
        }
    }

    public void insert(T value) {
        if (size == heap.length) {
            resize();
        }
        heap[size] = value;
        heapifyUp(size);
        size++;
    }

    public T extractMax() {
        if (size == 0) throw new NoSuchElementException("Heap is empty");
        T max = heap[0];
        heap[0] = heap[size - 1];
        size--;
        heapifyDown(0);
        return max;
    }

    private void resize() {
        @SuppressWarnings("unchecked")
        T[] newHeap = (T[]) new Comparable[heap.length * 2];
        System.arraycopy(heap, 0, newHeap, 0, size);
        heap = newHeap;
    }

    public int size() { return size; }

    public void printHeap() {
        for (int i = 0; i < size; i++) {
            System.out.print(heap[i] + " ");
        }
        System.out.println();
    }

    // Iterable implementation
    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int index = 0;

            @Override
            public boolean hasNext() {
                return index < size;
            }

            @Override
            public T next() {
                if (!hasNext()) throw new NoSuchElementException();
                return heap[index++];
            }
        };
    }
}
