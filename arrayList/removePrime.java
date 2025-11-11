package arrayList;

import java.util.*;

public class removePrime {
    public static void main(String args[]){
        ArrayList<Integer> al=new ArrayList<>();
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        for(int i=0;i<n;i++){
            al.add(sc.nextInt());
        }
        for(int i=al.size()-1;i>=0;i--){
            if(!checkPrime(al.get(i))){
                al.remove(i);
            }
        }
        System.out.println(al);
    }
    static boolean checkPrime(int a){
        int i=2;
        while(i*i<=a){
            if(a%i==0){
                return false;
            }
            i++;
        }
        return true;
    }
}
