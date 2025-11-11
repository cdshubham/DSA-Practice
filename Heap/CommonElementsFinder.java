package Heap;

import java.util.*;

public class CommonElementsFinder {

    // Approach 1: Using HashSet (for unique common elements)
    public static Set<Integer> getCommonElementsSet(int[] arr1, int[] arr2) {
        Set<Integer> set1 = new HashSet<>();
        for (int num : arr1) set1.add(num);

        Set<Integer> common = new HashSet<>();
        for (int num : arr2) {
            if (set1.contains(num)) {
                common.add(num);
            }
        }
        return common;
    }

    // Approach 2: Using HashMap (for counting frequency or duplicates)
    public static List<Integer> getCommonElementsMap(int[] arr1, int[] arr2) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int num : arr1) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        List<Integer> common = new ArrayList<>();
        for (int num : arr2) {
            if (freqMap.containsKey(num) && freqMap.get(num) > 0) {
                common.add(num);
                freqMap.put(num, freqMap.get(num) - 1); // decrease count
            }
        }
        return common;
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 2, 3, 4};
        int[] arr2 = {2, 2, 3, 5};

        // Using HashSet
        Set<Integer> commonSet = getCommonElementsSet(arr1, arr2);
        System.out.println("Common elements (unique): " + commonSet);

        // Using HashMap
        List<Integer> commonList = getCommonElementsMap(arr1, arr2);
        System.out.println("Common elements (with duplicates): " + commonList);
    }
}


class CommonElementsWithDuplicates2 {

    public static List<Integer> getCommonElements(int[] arr1, int[] arr2) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        List<Integer> result = new ArrayList<>();

        // Count frequency of elements in first array
        for (int num : arr1) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        // Check elements in second array
        for (int num : arr2) {
            if (freqMap.containsKey(num) && freqMap.get(num) > 0) {
                result.add(num);
                freqMap.put(num, freqMap.get(num) - 1); // decrease frequency
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 2, 3, 4};
        int[] arr2 = {2, 2, 3, 5};

        List<Integer> common = getCommonElements(arr1, arr2);
        System.out.println("Common elements (with duplicates): " + common);
    }
}
