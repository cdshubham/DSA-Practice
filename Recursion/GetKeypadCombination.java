package Recursion;

public class GetKeypadCombination {
    public static void main(String[] args) {
        String digits = "23";
        System.out.println("Combinations for digits " + digits + ":");
        getKeypadCombinations(digits, "", 0);
    }

    public static void getKeypadCombinations(String digits, String current, int index) {
        if (index == digits.length()) {
            System.out.println(current);
            return;
        }
        char digit = digits.charAt(index);
        String letters = getLettersForDigit(digit);
        for (char letter : letters.toCharArray()) {
            getKeypadCombinations(digits, current + letter, index + 1);
        }
    }

    public static String getLettersForDigit(char digit) {
        switch (digit) {
            case '2': return "abc";
            case '3': return "def";
            case '4': return "ghi";
            case '5': return "jkl";
            case '6': return "mno";
            case '7': return "pqrs";
            case '8': return "tuv";
            case '9': return "wxyz";
            default: return "";
        }
    }
    
}
