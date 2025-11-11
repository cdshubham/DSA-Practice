public class SearchIn2D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] arr = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        int x = sc.nextInt();
        int i = 0, j = m - 1; // start from top-right
        boolean found = false;

        while (i < n && j >= 0) {
            if (arr[i][j] == x) {
                System.out.println("Element found at index: (" + i + ", " + j + ")");
                found = true;
                break;
            } else if (arr[i][j] > x) {
                j--; // move left
            } else {
                i++; // move down
            }
        }

        if (!found) {
            System.out.println("Element not found");
        }

        sc.close();
    }
}
