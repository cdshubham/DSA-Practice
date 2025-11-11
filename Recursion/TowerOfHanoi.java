package Recursion;

public class TowerOfHanoi {
    public static void main(String[] args) {
        int n = 3; // Number of disks
        solveTowerOfHanoi(n, 'A', 'C', 'B');
    }

    public static void solveTowerOfHanoi(int n, char source, char destination, char auxiliary) {
        if (n == 1) {
            System.out.println("Move disk 1 from " + source + " to " + destination);
            return;
        }
        solveTowerOfHanoi(n - 1, source, auxiliary, destination);
        System.out.println("Move disk " + n + " from " + source + " to " + destination);
        solveTowerOfHanoi(n - 1, auxiliary, destination, source);
    }
}
