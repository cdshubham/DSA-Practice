
import java.util.Scanner;

public class benjaminBulb {
    public static void main(String[] args) {
        int n;
        Scanner sc=new Scanner(System.in);
        n=sc.nextInt();
        for(int i=1;i*i<=n;i++){
            System.out.print(i*i+" ");
        }
    }
}
