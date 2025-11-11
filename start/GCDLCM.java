import java.util.Scanner;

public class GCDLCM {
    public static void main(String[] args) {
        int n1;
        int n2;
        Scanner sc=new Scanner(System.in);
        n1=sc.nextInt();
        n2=sc.nextInt();
        int l1=n1,l2=n2;
        int temp;
        while(n2!=0){
            temp=n1%n2;
            n1=n2;
            n2=temp;
        }
        System.out.println(n1);
        System.out.println((l1*l2)/n1);
    }
}
