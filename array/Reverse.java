package array;

import java.util.Scanner;

public class Reverse {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the size of the array: ");
        int size = scanner.nextInt();
        int[] array = new int[size];
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < size; i++) {
            array[i] = scanner.nextInt();
        }
        System.out.println("Reversed array:");
        int i=0;
        int j=size-1;
        while(i<j){
            int temp=array[i];
            array[i]=array[j];
            array[j]=temp;
            i++;
            j--;
        }
        for (int num : array) {
            System.out.print(num + " ");
        }
    }
}
