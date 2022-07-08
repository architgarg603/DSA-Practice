class Solution {
    public int minCost(int[] houses, int[][] cost, int m, int n, int target) {
        
        int[][][] dp = new int[m+1][target+1][n+1];
        
        int ans = solve(houses, cost,dp, target,0,0) ;
        return  ans >= (int)(1e8) ? -1 : ans ;
        
    }
    
    public int solve(int[] ho, int[][] cost,int[][][] dp, int tar, int idx , int prev){
        if(idx == ho.length || tar<0) 
            return tar == 0 ? 0 : (int)(1e8);
        if(dp[idx][tar][prev] != 0)return dp[idx][tar][prev];
        int col = ho[idx];
        
        if(col != 0){
            return dp[idx][tar][prev] = solve(ho, cost,dp ,tar - (col == prev ? 0 : 1), idx+1, col);
        }
        int ans = Integer.MAX_VALUE;
        for(int i=1;i<=cost[0].length;i++){
            ans = Math.min(ans, solve(ho, cost, dp, tar - (i == prev ? 0 : 1), idx+1, i)+cost[idx][i-1]) ; 
        }
       
        return dp[idx][tar][prev] = ans;
    }
}