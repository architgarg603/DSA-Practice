class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int[][] dp = new int[triangle.size()+1][triangle.size()+1];
        for(int[] x : dp)
        Arrays.fill(x,-1);
        return solve(triangle,0,0,dp);
    }
    
    public int solve(List<List<Integer>> arr, int i, int j, int[][] dp){
        if(arr.size() == i)return dp[i][j] =  0;
        if(dp[i][j] != -1)return dp[i][j];
        return dp[i][j] =  Math.min(solve(arr,i+1,j,dp),solve(arr,i+1,j+1,dp)) +arr.get(i).get(j);
        
    }
}