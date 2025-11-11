package Recursion;

public class FindFirstOccurance {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 2, 4, 2, 5};
        int target = 2;
        int index = findFirstOccurrence(array, target, 0);
        if (index != -1) {
            System.out.println("First occurrence of " + target + " is at index: " + index);
        } else {
            System.out.println(target + " not found in the array.");
        }
    }

    public static int findFirstOccurrence(int[] array, int target, int index) {
        if (index == array.length) {
            return -1; // Base case: not found
        }
        if (array[index] == target) {
            return index; // Found
        }
        return findFirstOccurrence(array, target, index + 1); // Recur for next index
    }
}
