package array;

public class SubSetsOfArray {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        printAllSubsets(arr);
    }

    public static void printAllSubsets(int[] arr) {
        int n = arr.length;
        int totalSubsets = 1 << n; // 2^n subsets

        for (int i = 0; i < totalSubsets; i++) {
            System.out.print("{ ");
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) != 0) {
                    System.out.print(arr[j] + " ");
                }
            }
            System.out.println("}");
        }
    }   
}
