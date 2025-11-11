package Recursion;

public class PrintEncoding {
    public static void main(String[] args) {
        String str = "123";
        System.out.println("Encodings for the string \"" + str + "\" are:");
        printEncodings(str, "");
    }
    public static void printEncodings(String str, String current) {
        if (str.length() == 0) {
            System.out.println(current);
            return;
        }
        if (str.charAt(0) == '0') {
            return; // No encoding for numbers starting with '0'
        }
        // Single digit encoding
        int singleDigit = str.charAt(0) - '0';
        char singleChar = (char) ('a' + singleDigit - 1);
        printEncodings(str.substring(1), current + singleChar);
        
        // Double digit encoding
        if (str.length() >= 2) {
            int doubleDigit = Integer.parseInt(str.substring(0, 2));
            if (doubleDigit <= 26) {
                char doubleChar = (char) ('a' + doubleDigit - 1);
                printEncodings(str.substring(2), current + doubleChar);
            }
        }
    }
}
