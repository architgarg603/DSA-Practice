class Solution {
    public boolean canPartition(int[] arr) {
        int sum = 0;
        for(int x : arr)sum += x;
        if(sum == 0 || sum%2 > 0 )return false;
        
        int[][] dp =new int[arr.length+1][sum+1];
        Arrays.sort(arr);
        for(int[] x : dp)
            Arrays.fill(x,-1);
        
        return solve(arr,sum/2,arr.length-1,dp);
    }
    
    public boolean solve(int[] arr, int tar, int idx, int[][] dp){
        if(-1 == idx){
            return tar == 0;
        }
        
        if(dp[idx][tar] != -1)return dp[idx][tar] == 1 ? true : false;
        
        if(tar - arr[idx] >= 0)
            if(solve(arr,tar-arr[idx], idx-1, dp) == true){
                dp[idx][tar] = 1;
                return true;
            }
        
        boolean ans = solve(arr,tar, idx-1, dp);
        dp[idx][tar] = ans == true ? 1 : 0;
        return ans;
    }
    
    
}