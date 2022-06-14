class Solution {
    public int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length()+1][word2.length()+1];
        for(int[] x : dp)Arrays.fill(x,-1);
        return solve(word1,word2,0,0,dp);   
    }
    
    public int solve(String str1, String str2, int i, int j, int[][] dp){
        if(i == str1.length())return dp[i][j] = str2.length() - j ;
        if(j == str2.length())return dp[i][j] =  str1.length() - i ;
        if(dp[i][j] != -1)return dp[i][j];
        if(str1.charAt(i) == str2.charAt(j) )return dp[i][j] =  solve(str1,str2,i+1,j+1,dp);
        return dp[i][j] =  Math.min(solve(str1,str2,i+1,j,dp),solve(str1,str2,i,j+1,dp))+1;
        
    }
}