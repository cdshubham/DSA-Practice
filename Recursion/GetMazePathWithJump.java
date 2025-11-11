package Recursion;

public class GetMazePathWithJump {
    public static void main(String[] args) {
        int n = 3; // Number of rows
        int m = 3; // Number of columns
        System.out.println("Paths from (0,0) to (" + (n-1) + "," + (m-1) + ") with jumps:");
        getMazePathsWithJumps(0, 0, n - 1, m - 1, "");
    }
    public static void getMazePathsWithJumps(int sr, int sc, int dr, int dc, String path) {
        if (sr == dr && sc == dc) {
            System.out.println(path);
            return;
        }
        if (sr > dr || sc > dc) {
            return;
        }
        // Horizontal jumps
        for (int jump = 1; jump <= dc - sc; jump++) {
            getMazePathsWithJumps(sr, sc + jump, dr, dc, path + "H" + jump);
        }
        // Vertical jumps
        for (int jump = 1; jump <= dr - sr; jump++) {
            getMazePathsWithJumps(sr + jump, sc, dr, dc, path + "V" + jump);
        }
        // Diagonal jumps
        for (int jump = 1; jump <= Math.min(dr - sr, dc - sc); jump++) {
            getMazePathsWithJumps(sr + jump, sc + jump, dr, dc, path + "D" + jump);
        }
    }
}
