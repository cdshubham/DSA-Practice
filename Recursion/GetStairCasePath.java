package Recursion;

public class GetStairCasePath {
    public static void main(String[] args) {
        int n = 4; // Number of stairs
        System.out.println("Paths to climb " + n + " stairs:");
        getStairCasePaths(n, "");
    }
    public static void getStairCasePaths(int n, String path) {
        if (n == 0) {
            System.out.println(path);
            return;
        }
        if (n < 0) {
            return;
        }
        getStairCasePaths(n - 1, path + "1");
        getStairCasePaths(n - 2, path + "2");
        getStairCasePaths(n - 3, path + "3");
    }
}
