package stack;

import java.util.Scanner;
import java.util.Stack;

public class InfixEvaluation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            // Read the infix expression
            String exp = sc.nextLine().trim();

            if (exp.isEmpty()) {
                System.out.println("Expression is empty");
                return;
            }

            Stack<Integer> opnds = new Stack<>();
            Stack<Character> optors = new Stack<>();

            for (int i = 0; i < exp.length(); i++) {
                char ch = exp.charAt(i);

                if (ch == ' ') {
                    continue;
                } else if (ch == '(') {
                    optors.push(ch);
                } else if (Character.isDigit(ch)) {
                    StringBuilder num = new StringBuilder();
                    while (i < exp.length() && Character.isDigit(exp.charAt(i))) {
                        num.append(exp.charAt(i));
                        i++;
                    }
                    i--;
                    opnds.push(Integer.parseInt(num.toString()));
                } else if (ch == ')') {
                    while (!optors.isEmpty() && optors.peek() != '(') {
                        if (opnds.size() < 2) {
                            System.out.println("Invalid expression: insufficient operands");
                            return;
                        }
                        char optor = optors.pop();
                        int v2 = opnds.pop();
                        int v1 = opnds.pop();
                        opnds.push(operation(v1, v2, optor));
                    }

                    if (!optors.isEmpty() && optors.peek() == '(') {
                        optors.pop(); // Pop the matching '('
                    } else {
                        System.out.println("Invalid expression: unmatched closing parenthesis");
                        return;
                    }
                } else if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                    while (!optors.isEmpty() && optors.peek() != '(' &&
                           precedence(ch) <= precedence(optors.peek())) {
                        if (opnds.size() < 2) {
                            System.out.println("Invalid expression: insufficient operands");
                            return;
                        }
                        char optor = optors.pop();
                        int v2 = opnds.pop();
                        int v1 = opnds.pop();
                        opnds.push(operation(v1, v2, optor));
                    }
                    optors.push(ch);
                } else {
                    System.out.println("Invalid character in expression: " + ch);
                    return;
                }
            }

            // Evaluate remaining operators
            while (!optors.isEmpty()) {
                if (optors.peek() == '(') {
                    System.out.println("Invalid expression: unmatched opening parenthesis");
                    return;
                }
                if (opnds.size() < 2) {
                    System.out.println("Invalid expression: insufficient operands");
                    return;
                }
                char optor = optors.pop();
                int v2 = opnds.pop();
                int v1 = opnds.pop();
                opnds.push(operation(v1, v2, optor));
            }

            if (opnds.size() == 1) {
                System.out.println(opnds.pop());
            } else {
                System.out.println("Invalid expression: too many operands");
            }

        } catch (ArithmeticException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            sc.close();
        }
    }

    public static int precedence(char optor) {
        if (optor == '+' || optor == '-') return 1;
        else if (optor == '*' || optor == '/') return 2;
        return 0;
    }

    public static int operation(int v1, int v2, char optor) {
        return switch(optor) {
            case '+' -> v1 + v2;
            case '-' -> v1 - v2;
            case '*' -> v1 * v2;
            case '/' -> {
                if (v2 == 0) throw new ArithmeticException("Division by zero");
                yield v1 / v2;
            }
            default -> throw new IllegalArgumentException("Invalid operator: " + optor);
        };
    }
}
