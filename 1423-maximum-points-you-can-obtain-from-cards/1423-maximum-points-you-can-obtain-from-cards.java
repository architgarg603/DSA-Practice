class Solution {
    public int maxScore(int[] arr, int k) {
        int sum = 0;
        for(int i=0;i<k;i++)sum += arr[i];
        int ans = sum;
         for(int i=0;i<k;i++){
             sum-= arr[k-1-i];
             sum += arr[arr.length -1-i];
             ans = Math.max(ans,sum);
         }
        
        return ans;
        
        
    }
}