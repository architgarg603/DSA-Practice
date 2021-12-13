import java.io.*;
import java.util.*;
 
public class test{
    public static void main (String[] args){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int t = scn.nextInt();
        String str = scn.next();
        
        char[] arr = new char[n];
        for(int i =0;i<n;i++)arr[i] = str.charAt(i);
        
        while(t-->0){
            for(int i=0;i<arr.length-1;i++){
                if(arr[i]=='B' && arr[i+1] == 'G'){
                    arr[i] = 'G';
                    arr[i+1] = 'B';
                    i++;
                }
            }
        }
        
        for(int x=0;x<n;x++){
            System.out.print(arr[x]);
        }
    }
}