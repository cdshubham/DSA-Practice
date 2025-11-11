package TwoDArray;

import java.util.Scanner;

public class ExitPointOfMatrix {
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

        int dir = 0; // 0=right, 1=down, 2=left, 3=up
        int i = 0, j = 0;

        while (true) {
            dir = (dir + arr[i][j]) % 4;

            if (dir == 0) { // right
                j++;
            } else if (dir == 1) { // down
                i++;
            } else if (dir == 2) { // left
                j--;
            } else { // up
                i--;
            }

            // Exit condition
            if (i < 0) {
                i++;
                break;
            } else if (j < 0) {
                j++;
                break;
            } else if (i == n) {
                i--;
                break;
            } else if (j == m) {
                j--;
                break;
            }
        }

        // Print exit point
        System.out.println(i + " " + j);
    }
}
