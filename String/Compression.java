package String;

import java.util.*;

//Compression 1
// public class Compression {
//     public static void main(String args[]) {
//         Scanner sc = new Scanner(System.in);
//         String str = sc.nextLine();
//         StringBuffer res = new StringBuffer();
        
//         for (char c : str.toCharArray()) {
//             if (res.isEmpty() || res.charAt(res.length() - 1) != c) {
//                 res.append(c);
//             }
//         }

//         System.out.println(res);
//     }
// }

//Compression 1
// public class Compression {
//     public static void main(String args[]) {
//         Scanner sc = new Scanner(System.in);
//         String str = sc.nextLine();
//         StringBuffer res=new StringBuffer();
//         for (int i = 0; i < str.length(); i++) {
//             char curr=str.charAt(i);
//             char prev=str.charAt(i-1);
//             if(curr!=prev){
//                 res.append(curr);
//             }
//         }
//         System.out.println(res);
//     }
// }

//Compression 2
public class Compression {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        StringBuffer res=new StringBuffer();
        int i=0,j=0;
        while (j<str.length()) { 
            if(str.charAt(i)!=str.charAt(j)){
                res.append(str.charAt(i));
                res.append(j-i);
                i=j;
            }
            j++;
        }
        res.append(str.charAt(i));
        res.append(j-i);
        System.out.println(res);
    }
}
