package Recursion;

public class PowerLogarithmic {
    public static void main(String[] args) {
        int base = 2; // Example base
        int exponent = 10; // Example exponent
        int result = power(base, exponent);
        System.out.println(base + " raised to the power of " + exponent + " is: " + result);
    }
    public static int power(int base, int exponent) {
        if (exponent == 0) {
            return 1; // Base case: any number raised to the power of 0 is 1
        }
        if (exponent % 2 == 0) {
            int halfPower = power(base, exponent / 2);
            return halfPower * halfPower; // If exponent is even
        } else {
            return base * power(base, exponent - 1); // If exponent is odd
        }
    }
}
