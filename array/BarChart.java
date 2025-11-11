package array;

import java.util.Scanner;

public class BarChart {
    public static void main(String[] args) {
        int n;
        Scanner sc=new Scanner(System.in);
        n=sc.nextInt();
        int arr[]=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        int max=arr[0];
        for(int i=0;i<arr.length;i++){
            if(max<arr[i]){
                max=arr[i];
            }
        }
        while(max!=0){
            for(int j=0;j<n;j++){
                if(arr[j]>=max){
                    System.out.print("* ");
                }else{
                    System.out.print("  ");
                }
            }
            max--;
            System.out.println();
        }
    }
}
