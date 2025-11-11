package TwoDArray;

import java.util.Scanner;

public class WaveTraversal {
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

        // Wave Traversal
        for (int i = 0; i < c; i++) {
            if (i % 2 == 0) {
                // top to bottom
                for (int j = 0; j < r; j++) {
                    System.out.print(arr[j][i] + " ");
                }
            } else {
                // bottom to top
                for (int j = r - 1; j >= 0; j--) {
                    System.out.print(arr[j][i] + " ");
                }
            }
        }
    }
}
