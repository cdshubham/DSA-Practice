package Recursion;

public class DisplayArray {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5};
        System.out.print("Array elements are: ");
        displayArray(array, 0);
    }

    public static void displayArray(int[] array, int index) {
        if (index == array.length) {
            return;
        }
        System.out.print(array[index] + " ");
        displayArray(array, index + 1);
    }
}
