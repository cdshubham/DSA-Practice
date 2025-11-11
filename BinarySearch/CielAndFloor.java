package BinarySearch;

public class CielAndFloor {
    public static void main(String[] args) {
        int[] arr = {1, 2, 8, 10, 10, 12, 19};
        int target = 5;
        int[] result = findCielAndFloor(arr, target);
        System.out.println("Ceiling: " + result[0] + ", Floor: " + result[1]);
    }
    public static int[] findCielAndFloor(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        int ceil = -1;
        int floor = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                return new int[]{arr[mid], arr[mid]};
            } else if (arr[mid] < target) {
                floor = arr[mid];
                left = mid + 1;
            } else {
                ceil = arr[mid];
                right = mid - 1;
            }
        }
        return new int[]{ceil, floor};
    }
    
}
