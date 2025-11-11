package start;

import java.util.*;

public class PrimeTillN {
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int num=sc.nextInt();
        System.out.print("1 ");
        for(int i=2;i<=num;i++){
            int flag=0;
            for(int j=2;j*j<=i;j++){
                if(i%j==0){
                    flag=1;
                    break;
                }
            }
            if(flag==0){
                System.out.print(i+" ");
            }
        }

    }
}
