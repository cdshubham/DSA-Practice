package Recursion;

public class TargetSumSubset {
    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 40, 50};
        int target = 60;
        System.out.println("Subsets of the array that sum to " + target + " are:");
        findTargetSumSubsets(arr, 0, "", 0, target);
    }
    public static void findTargetSumSubsets(int[] arr, int index, String currentSubset, int currentSum, int target) {
        if (index == arr.length) {
            if (currentSum == target) {
                System.out.println(currentSubset);
            }
            return;
        }
        // Include the current element
        findTargetSumSubsets(arr, index + 1, currentSubset + arr[index] + " ", currentSum + arr[index], target);
        // Exclude the current element
        findTargetSumSubsets(arr, index + 1, currentSubset, currentSum, target);
    }
    
}
