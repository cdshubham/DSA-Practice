package stack;

import java.util.Stack;

public class MinimumStackConstant {
    public class MinStack {
        Stack<Integer> data;
        int min;

        public MinStack() {
            data = new Stack<>();
        }

        int size() {
            return data.size();
        }

        void push(int val) {
            if (data.isEmpty()) {
                data.push(val);
                min = val;
            } else if (val >= min) {
                data.push(val);
            } else {
                // encode the value
                data.push(2 * val - min);
                min = val;
            }
        }

        int pop() {
            if (data.isEmpty()) {
                System.out.println("Stack underflow");
                return -1;
            }

            int top = data.pop();
            if (top >= min) {
                return top;
            } else {
                int originalMin = min;
                // Decode the previous min
                min = 2 * min - top;
                return originalMin;
            }
        }

        int top() {
            if (data.isEmpty()) {
                System.out.println("Stack underflow");
                return -1;
            }

            int top = data.peek();
            if (top >= min) {
                return top;
            } else {
                // Encoded value; actual top is min
                return min;
            }
        }

        int min() {
            if (data.isEmpty()) {
                System.out.println("Stack underflow");
                return -1;
            }
            return min;
        }
    }
}
