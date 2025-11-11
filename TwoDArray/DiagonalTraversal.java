package TwoDArray;

import java.util.Scanner;

public class DiagonalTraversal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] arr = new int[n][m];

        // Input
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        diagonalTraversal(arr);
    }

    public static void diagonalTraversal(int[][] arr) {
        int n = arr.length;
        int m = arr[0].length;

        // Diagonals starting from top row
        for (int gap = 0; gap < m; gap++) {
            int i = 0;
            int j = gap;
            while (i < n && j < m) {
                System.out.print(arr[i][j] + " ");
                i++;
                j++;
            }
            System.out.println();
        }

        // Diagonals starting from first column (excluding top-left)
        for (int gap = 1; gap < n; gap++) {
            int i = gap;
            int j = 0;
            while (i < n && j < m) {
                System.out.print(arr[i][j] + " ");
                i++;
                j++;
            }
            System.out.println();
        }
    }
}
