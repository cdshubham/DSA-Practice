package Recursion;

public class PrintSubsequence {
    public static void main(String[] args) {
        int[] array = {1, 2, 3};
        System.out.println("Subsequences of the array are:");
        printSubsequences(array, 0, "");
    }

    public static void printSubsequences(int[] array, int index, String current) {
        if (index == array.length) {
            System.out.println(current);
            return;
        }
        // Include the current element
        printSubsequences(array, index + 1, current + array[index] + " ");
        // Exclude the current element
        printSubsequences(array, index + 1, current);
    }
}
