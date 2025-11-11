import java.util.Scanner;

public class primeFactor {
    public static void main(String[] args) {
        int no;
        Scanner sc=new Scanner(System.in);
        no=sc.nextInt();
        for(int i=2;i*i<=no;i++){
            while(no%i==0){
                no=no/i;
                System.out.println(i);
            }
        }
        if(no!=1)    System.out.println(no);
    }
}
