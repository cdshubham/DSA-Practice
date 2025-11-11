package Recursion;

public class PrintIncreasingDecreasing {
    public static void main(String[] args) {
        printIncreasingDecreasing(5);
    }

    public static void printIncreasingDecreasing(int n) {
        if (n == 0) {
            return;
        }
        System.out.println(n);
        printIncreasingDecreasing(n - 1);
        System.out.println(n);
    }

}
