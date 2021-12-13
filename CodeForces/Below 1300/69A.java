import java.util.*;
import java.io.*;
 
public class test{
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        long x=0,y=0,z=0;
        int n = scn.nextInt();
        
        for(int i=0;i<n;i++){
            int a = scn.nextInt();
            int b = scn.nextInt();
            int c = scn.nextInt();
            
            x += a;
            y+=b;
            z+=c;
        }
        
        if(x==0 && y==0 && z==0)
            System.out.println("YES");
        else
         System.out.println("NO");
    }
}