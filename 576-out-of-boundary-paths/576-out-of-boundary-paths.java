class Solution {
    static long mod = (long)(1e9+7);
    public int findPaths(int n, int m, int tar, int i, int j) {
        if(i<0 || j<0 || i>=n || j>=m)return 1;
        if(tar<=0)return 0;
        
        int[][][] dp = new int[n][m][tar+1];
        for(int[][] y : dp)
            for(int[] x : y)
                Arrays.fill(x,-1);
        
        return solve(n,m,tar,i,j, dp);
    }
    public int solve(int n, int m, int tar, int i, int j, int[][][] dp) {
        if(i<0 || j<0 || i>=n || j>=m)return 1;
        if(tar<=0)return 0;
        if(dp[i][j][tar] != -1)return dp[i][j][tar];
        long ans = 0;
        ans += solve(n,m,tar-1,i+1,j,dp);
        ans = ans%mod;
        ans += solve(n,m,tar-1,i-1,j,dp);
        ans = ans%mod;
        ans += solve(n,m,tar-1,i,j+1,dp);
        ans = ans%mod;
        ans += solve(n,m,tar-1,i,j-1,dp);
        ans = ans%mod;
        
        return dp[i][j][tar] = (int)(ans%mod);
    }
}