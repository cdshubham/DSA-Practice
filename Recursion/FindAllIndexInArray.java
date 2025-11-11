package Recursion;

public class FindAllIndexInArray {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 2, 4, 2, 5};
        int target = 2;
        System.out.print("Indices of target " + target + " are: ");
        findAllIndices(array, target, 0);
    }

    public static void findAllIndices(int[] array, int target, int index) {
        if (index == array.length) {
            return;
        }
        if (array[index] == target) {
            System.out.print(index + " ");
        }
        findAllIndices(array, target, index + 1);
    }
}
