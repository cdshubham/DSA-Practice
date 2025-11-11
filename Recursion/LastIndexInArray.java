package Recursion;

public class LastIndexInArray {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 2, 4, 2, 5};
        int target = 2;
        int index = findLastIndex(array, target, 0);
        if (index != -1) {
            System.out.println("Last occurrence of " + target + " is at index: " + index);
        } else {
            System.out.println(target + " not found in the array.");
        }
    }

    public static int findLastIndex(int[] array, int target, int index) {
        if (index == array.length) {
            return -1; // Base case: not found
        }
        int lastIndex = findLastIndex(array, target, index + 1);
        if (lastIndex != -1) {
            return lastIndex; // Found in the rest of the array
        }
        if (array[index] == target) {
            return index; // Found at current index
        }
        return -1; // Not found
    }
}
