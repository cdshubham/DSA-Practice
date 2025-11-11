package start;

import java.util.Scanner;

public class reverseNumber {
    public static void main(String args[]){
        int num;
        Scanner sc=new Scanner(System.in);
        num=sc.nextInt();

        int newNum=0;
        while(num!=0){
            newNum=newNum*10+num%10;
            num=num/10;
        }
        System.out.println(newNum);
    }
}
