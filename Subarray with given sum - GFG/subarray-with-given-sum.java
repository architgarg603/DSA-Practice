// { Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class Main{
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int s = sc.nextInt();

            int[] m = new int[n];
            for (int j = 0; j < n; j++) {
                m[j] = sc.nextInt();
            }
            
            Solution obj = new Solution();
            ArrayList<Integer> res = obj.subarraySum(m, n, s);
            for(int ii = 0;ii<res.size();ii++)
                System.out.print(res.get(ii) + " ");
            System.out.println();
        }
    }

}// } Driver Code Ends


class Solution
{
    //Function to find a continuous sub-array which adds up to a given number.
    static ArrayList<Integer> subarraySum(int[] arr, int n, int s) 
    {
        // Your code here
         ArrayList<Integer> al = new ArrayList<>();
         if(s==0){
            al.add(-1);
            return al;
         }
        int sum=arr[0];
        int i=0;
        int j=1;
        while(j<arr.length){
            if(sum==s){
                
                al.add(i+1);
                al.add(j);
                return al;
            } 
          
         if(sum<s) {
             sum+=arr[j];
             j++;
         }
         else if(i<j){
             sum-=arr[i];
             i++;
         }
           
               
           
        }
        while(i<j && sum > s){
            sum-=arr[i++];
        }
         if(sum==s && (i+1)<=j){
                al.add(i+1);
                al.add(j);
                return al;
            } 
          
        al.add(-1);
        return al;
    }
}