package Recursion;

public class GetMazePath {
    public static void main(String[] args) {
        int n = 3; // Number of rows
        int m = 3; // Number of columns
        System.out.println("Paths from (0,0) to (" + (n-1) + "," + (m-1) + "):");
        getMazePaths(0, 0, n - 1, m - 1, "");
    }
    public static void getMazePaths(int sr, int sc, int dr, int dc, String path) {
        if (sr == dr && sc == dc) {
            System.out.println(path);
            return;
        }
        if (sr > dr || sc > dc) {
            return;
        }
        getMazePaths(sr + 1, sc, dr, dc, path + "V"); // Move Down
        getMazePaths(sr, sc + 1, dr, dc, path + "H"); // Move Right
    }
}
