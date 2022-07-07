class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length()+s2.length() != s3.length())return false;
        int i = s1.length(), j = s2.length(), k= s3.length();
        int[][][] dp = new int[i+1][j+1][k+1];
        for(int[][] x : dp)
            for(int[] y : x)
                Arrays.fill(y,-1);
        
        return solve(s1,s2,s3,dp,0,0,0) == 1;
               
    }
    
    public int solve(String s1, String s2, String s3,int[][][] dp, int i, int j, int k){
        if(i == s1.length() && j == s2.length() && k == s3.length())return 1;
        
        int x =s1.length(), y = s2.length();
        
        if(dp[i][j][k] != -1)return dp[i][j][k];
        
        if( i!= x && s1.charAt(i) == s3.charAt(k) && solve(s1,s2,s3,dp,i+1,j,k+1) == 1) return dp[i][j][k]=  1;
        if(j != y && s2.charAt(j) == s3.charAt(k) && solve(s1,s2,s3,dp,i,j+1,k+1) == 1) return dp[i][j][k]=  1;
        
        return dp[i][j][k] = 0;
        
    }
}