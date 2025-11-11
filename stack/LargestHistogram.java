package stack;

import java.util.Scanner;
import java.util.Stack;

public class LargestHistogram {
    public static void main(String[] args) {
        int n;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int arr[] = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // Right Boundary (Next Smaller to Right)
        int rb[] = new int[n];
        Stack<Integer> st = new Stack<>();
        st.push(n - 1);
        rb[n - 1] = n;

        for (int i = n - 2; i >= 0; i--) {
            while (!st.isEmpty() && arr[i] <= arr[st.peek()]) {
                st.pop();
            }
            if (st.isEmpty()) {
                rb[i] = n;
            } else {
                rb[i] = st.peek();
            }
            st.push(i);
        }

        // Left Boundary (Next Smaller to Left)
        int lb[] = new int[n];
        st = new Stack<>();
        st.push(0);
        lb[0] = -1;

        for (int i = 1; i < n; i++) {
            while (!st.isEmpty() && arr[i] <= arr[st.peek()]) {
                st.pop();
            }
            if (st.isEmpty()) {
                lb[i] = -1;
            } else {
                lb[i] = st.peek();
            }
            st.push(i);
        }

        // Calculate Max Area
        int maxArea = 0;
        for (int i = 0; i < n; i++) {
            int width = rb[i] - lb[i] - 1;
            int area = arr[i] * width;
            maxArea = Math.max(maxArea, area);
        }

        System.out.println(maxArea);
    }
}