package String;
import java.util.*;

class SubPalendrome{

    public static boolean isPallindrome(String ss){
        int i=0,j=ss.length()-1;
        while(i<j){
            if(ss.charAt(i)!=ss.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String str=sc.nextLine();
        for(int i=0;i<str.length();i++){
            for(int j=i+1;j<=str.length();j++){
                String ss=str.substring(i,j);
                if(isPallindrome(ss)){
                    System.out.println(ss);
                }
            }
        }
    }
}