package stack;

import java.util.Scanner;
import java.util.Stack;

public class SlidingWindowMaximum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Input size of array and window size
        int n = sc.nextInt();
        int k = sc.nextInt();  // Size of sliding window
        
        // Input validation
        if (n <= 0) {
            System.out.println("Array size must be positive");
            sc.close();
            return;
        }
        if (k <= 0 || k > n) {
            System.out.println("Invalid window size");
            sc.close();
            return;
        }
        
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        Stack<Integer> st = new Stack<>();
        int[] nge = new int[n];  // Stores the index of the next greater element

        // Compute NGE from right to left
        nge[n - 1] = n;
        st.push(n - 1);
        for (int i = n - 2; i >= 0; i--) {
            while (!st.isEmpty() && arr[i] >= arr[st.peek()]) {
                st.pop();
            }
            nge[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }

        int j = 0;
        for (int i = 0; i <= n - k; i++) {
            if (j < i) {
                j = i;
            }
            while (nge[j] < i + k) {
                j = nge[j];
            }
            System.out.print(arr[j] + " ");
        }
        
        sc.close();
    }
}