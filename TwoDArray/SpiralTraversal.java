package TwoDArray;

import java.util.Scanner;

public class SpiralTraversal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input
        int r = sc.nextInt();
        int c = sc.nextInt();
        int[][] arr = new int[r][c];

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        // Spiral Traversal
        int top = 0, bottom = r - 1, left = 0, right = c - 1;

        while (top <= bottom && left <= right) {
            // Top row (left → right)
            for (int i = left; i <= right; i++) {
                System.out.print(arr[top][i] + " ");
            }
            top++;

            // Right column (top → bottom)
            for (int i = top; i <= bottom; i++) {
                System.out.print(arr[i][right] + " ");
            }
            right--;

            if (top <= bottom) {
                // Bottom row (right → left)
                for (int i = right; i >= left; i--) {
                    System.out.print(arr[bottom][i] + " ");
                }
                bottom--;
            }

            if (left <= right) {
                // Left column (bottom → top)
                for (int i = bottom; i >= top; i--) {
                    System.out.print(arr[i][left] + " ");
                }
                left++;
            }
        }
    }
}
