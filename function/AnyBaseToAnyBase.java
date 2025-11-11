import java.util.Scanner;

public class AnyBaseToAnyBase {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int b1=sc.nextInt();
        int b2=sc.nextInt();
        int newNo=changeToDecimal(n,b1);
        int finalNo=DecimalToAny(newNo,b2);
        System.out.println(finalNo);
    }
    static int changeToDecimal(int n,int b){
        int p=1,newNo=0;
        while(n!=0){
            newNo+=(n%10)*p;
            n/=10;
            p=p*b;
        }
        return newNo;
    }
    static int DecimalToAny(int n,int b){
        int p=1,newNo=0;
        while(n!=0){
            newNo+=(n%b)*p;
            n/=b;
            p=p*10;
        }
        return newNo;
    }
}
