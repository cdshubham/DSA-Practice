package Heap;

import java.util.*;

public class LongestConsecutiveSequence {

    // Function to find length of longest consecutive sequence
    public static int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;

        Set<Integer> set = new HashSet<>();
        for (int num : nums) set.add(num);

        int longest = 0;

        for (int num : nums) {
            // Only start counting if 'num-1' is not in set (start of sequence)
            if (!set.contains(num - 1)) {
                int currentNum = num;
                int currentStreak = 1;

                while (set.contains(currentNum + 1)) {
                    currentNum++;
                    currentStreak++;
                }

                longest = Math.max(longest, currentStreak);
            }
        }

        return longest;
    }

    public static void main(String[] args) {
        int[] nums = {100, 4, 200, 1, 3, 2};
        System.out.println("Length of Longest Consecutive Sequence: " + longestConsecutive(nums));
    }
}

