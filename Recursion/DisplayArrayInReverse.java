package Recursion;

public class DisplayArrayInReverse {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5};
        System.out.print("Array elements in reverse are: ");
        displayArrayInReverse(array, 0);
    }

    public static void displayArrayInReverse(int[] array, int index) {
        if (index == array.length) {
            return;
        }
        displayArrayInReverse(array, index + 1);
        System.out.print(array[index] + " ");
    }
}
