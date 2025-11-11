package queue;

public class QueueImpl {
    public class Queue {
        int[] data;
        int front;
        int size;

        Queue(int cap) {
            data = new int[cap];
            front = 0;
            size = 0;
        }

        int size() {
            return size;
        }

        void display() {
            for (int i = 0; i < size; i++) {
                int idx = (front + i) % data.length;
                System.out.print(data[idx] + " ");
            }
            System.out.println();
        }

        void add(int val) {
            if (size == data.length) {
                System.out.println("Queue Overflow");
            } else {
                int rear = (front + size) % data.length;
                data[rear] = val;
                size++;
            }
        }

        int peek() {
            if (size == 0) {
                System.out.println("Queue Underflow");
                return -1;
            } else {
                return data[front];
            }
        }

        int remove() {
            if (size == 0) {
                System.out.println("Queue Underflow");
                return -1;
            } else {
                int val = data[front];
                front = (front + 1) % data.length;
                size--;
                return val;
            }
        }
    }
}
