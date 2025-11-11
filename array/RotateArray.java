package array;

public class RotateArray {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the size of the array: ");
        int size=sc.nextInt();
        int[] array=new int[size];
        System.out.println("Enter the elements of the array: ");
        for(int i=0;i<size;i++){
            array[i]=sc.nextInt();
        }
        System.out.print("Enter the number of rotations: ");
        int rotations=sc.nextInt();
        rotateArray(array,rotations);
        System.out.println("Array after "+rotations+" rotations: ");
        for(int i=0;i<size;i++){
            System.out.print(array[i]+" ");
        }
    }
    public static void rotateArray(int[] array, int rotations) {
        int n = array.length;
        rotations = rotations % n; // In case rotations are more than array size
        reverse(array, 0, n - 1);
        reverse(array, 0, rotations - 1);
        reverse(array, rotations, n - 1);
    }
    public static void reverse(int[] array, int start, int end) {
        while (start < end) {
            int temp = array[start];
            array[start] = array[end];
            array[end] = temp;
            start++;
            end--;
        }
    }
    
}
