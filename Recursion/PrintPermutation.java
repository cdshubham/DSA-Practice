package Recursion;

public class PrintPermutation {
    public static void main(String[] args) {
        String str = "abc";
        System.out.println("Permutations of the string \"" + str + "\" are:");
        printPermutations(str, "");
    }
    public static void printPermutations(String str, String current) {
        if (str.length() == 0) {
            System.out.println(current);
            return;
        }
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            String ros = str.substring(0, i) + str.substring(i + 1);
            printPermutations(ros, current + ch);
        }
    }
}
