package Recursion;

public class Power {
    public static void main(String[] args) {
        int base = 2;
        int exponent = 3;
        int result = power(base, exponent);
        System.out.println(base + " raised to the power of " + exponent + " is: " + result);
    }

    public static int power(int base, int exponent) {
        if (exponent == 0) {
            return 1; // Base case: any number raised to the power of 0 is 1
        }
        return base * power(base, exponent - 1); // Recursive case
    }
}
