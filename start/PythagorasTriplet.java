import java.util.Scanner;

public class PythagorasTriplet {
    public static void main(String[] args) {
        int a, b, c;
        Scanner sc = new Scanner(System.in);
        
        a = sc.nextInt();
        b = sc.nextInt();
        c = sc.nextInt();
        
        int max = Math.max(a, Math.max(b, c));
        
        if (max == a) {
            System.out.println((a * a == b * b + c * c) ? "Yes" : "No");
        } else if (max == b) {
            System.out.println((b * b == a * a + c * c) ? "Yes" : "No");
        } else {
            System.out.println((c * c == a * a + b * b) ? "Yes" : "No");
        }
        
        sc.close();
    }
}
