package TwoDArray;

import java.util.Scanner;

public class SaddlePoint {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] arr = new int[n][m];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }

            boolean found = false;
            for (int i = 0; i < n; i++) {
                int minColIndex = 0;
                for (int j = 1; j < m; j++) {
                    if (arr[i][j] < arr[i][minColIndex]) {
                        minColIndex = j;
                    }
                }

                boolean isSaddlePoint = true;
                for (int k = 0; k < n; k++) {
                    if (arr[k][minColIndex] > arr[i][minColIndex]) {
                        isSaddlePoint = false;
                        break;
                    }
                }

                if (isSaddlePoint) {
                    System.out.println(arr[i][minColIndex]);
                    found = true;
                }
            }

            if (!found) {
                System.out.println("No Saddle Point Found");
            }
        }
    }
}
