package Recursion;

public class FindMaximumOfArray {
    public static void main(String[] args) {
        int[] array = {3, 5, 7, 2, 8, -1, 4};
        int max = findMaximum(array, 0);
        System.out.println("The maximum element in the array is: " + max);
    }

    public static int findMaximum(int[] array, int index) {
        if (index == array.length - 1) {
            return array[index]; // Base case: only one element left
        }
        int maxOfRest = findMaximum(array, index + 1); // Recursive case
        return Math.max(array[index], maxOfRest); // Return the maximum of current and rest
    }
    
}
