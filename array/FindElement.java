package array;

import java.util.Scanner;

public class FindElement {
    public static void main(String[] args) {
        int n;
        Scanner sc=new Scanner(System.in);
        n=sc.nextInt();
        int arr[]=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        int num=sc.nextInt();
        int find=-1;
        for(int i=0;i<arr.length;i++){
            if(num==arr[i]){
                find=i;
                break;
            }
        }
        System.out.print(find);
    }
}
