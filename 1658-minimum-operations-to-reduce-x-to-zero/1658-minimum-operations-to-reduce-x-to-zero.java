class Solution {
    public int minOperations(int[] arr, int x) {
        int sum = 0;
        int n = arr.length;
        for(int i=0;i<n;i++)sum += arr[i];
        int tar = sum - x;
        
        int si=0,ei=0,temp=0;
        int ans = -1;
        while(ei<n){
           temp += arr[ei++];
           while(temp>tar && si<ei )temp-= arr[si++]; 
            if(temp == tar)ans = Math.max(ans, ei-si);
        }
        
        return ans == -1 ? -1 : n-ans;
        
    }                    
   
}