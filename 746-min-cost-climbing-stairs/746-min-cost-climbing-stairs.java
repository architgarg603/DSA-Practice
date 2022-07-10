class Solution {
    public int minCostClimbingStairs(int[] arr) {
        int n = arr.length;
        int[] dp = new int[n+1];
        dp[n] = 0;
        dp[n-1] = arr[n-1];
        for(int i = n-2;i>=0;i--){
            dp[i] = Math.min(dp[i+1],dp[i+2])+arr[i];
        }
        return  Math.min(dp[1],dp[0]);
        
    }
}