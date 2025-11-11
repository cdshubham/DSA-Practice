package Heap;

import java.util.*;

public class FrequencyAnalyzer {

    // Approach 1: HashMap only
    public static char highestFrequencyChar(String str) {
        Map<Character, Integer> freqMap = new HashMap<>();
        for (char ch : str.toCharArray()) {
            freqMap.put(ch, freqMap.getOrDefault(ch, 0) + 1);
        }

        char maxChar = '\0';
        int maxFreq = 0;
        for (Map.Entry<Character, Integer> entry : freqMap.entrySet()) {
            if (entry.getValue() > maxFreq) {
                maxFreq = entry.getValue();
                maxChar = entry.getKey();
            }
        }
        return maxChar;
    }

    // Approach 2: HashMap + Max Heap (top 1 or top K)
    public static List<Character> topKFrequentChars(String str, int k) {
        Map<Character, Integer> freqMap = new HashMap<>();
        for (char ch : str.toCharArray()) {
            freqMap.put(ch, freqMap.getOrDefault(ch, 0) + 1);
        }

        PriorityQueue<Map.Entry<Character, Integer>> maxHeap =
                new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());

        maxHeap.addAll(freqMap.entrySet());

        List<Character> result = new ArrayList<>();
        for (int i = 0; i < k && !maxHeap.isEmpty(); i++) {
            result.add(maxHeap.poll().getKey());
        }

        return result;
    }

    public static void main(String[] args) {
        String str = "aabbbccdde";

        // Highest frequency character
        System.out.println("Highest frequency character: " + highestFrequencyChar(str));

        // Top 3 frequent characters
        List<Character> top3 = topKFrequentChars(str, 3);
        System.out.println("Top 3 frequent characters: " + top3);
    }
}
