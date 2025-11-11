package array;

import java.util.Scanner;

public class InverseOfArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the size of the array: ");
        int size = scanner.nextInt();
        int[] array = new int[size];
        System.out.println("Enter the elements of the array (values should be from 0 to " + (size - 1) + "):");
        
        boolean valid = true;
        for (int i = 0; i < size; i++) {
            array[i] = scanner.nextInt();
            if (array[i] < 0 || array[i] >= size) {
                valid = false;
            }
        }

        if (!valid) {
            System.out.println("Invalid input! Elements must be between 0 and " + (size - 1));
        } else {
            int[] inverse = new int[size];
            for (int i = 0; i < size; i++) {
                inverse[array[i]] = i;
            }
            System.out.println("Inverse of the array:");
            for (int i : inverse) {
                System.out.print(i + " ");
            }
        }
        scanner.close();
    }
}
