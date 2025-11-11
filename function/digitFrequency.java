package function;

import java.util.Scanner;

public class digitFrequency {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int b=sc.nextInt();
        int fre=getDigitFrequency(n,b);
        System.out.print(fre);
    }
    static int getDigitFrequency(int n,int b){
        int count=0;
        while(n!=0){
            if(n%10==b){
                count++;
            }
            n=n/10;
        }
        return count;
    }

}
