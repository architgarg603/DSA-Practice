class Solution {
    public String longestPalindrome(String str) {
        int n = str.length();
        int[][] dp = new int[n][n];
        int len = 0;
        int si = 0;
        int count = 0;
        for (int gap = 0; gap < n; gap++) {
            for (int i = 0, j = gap; j < n; i++, j++) {
                if (gap == 0)
                    dp[i][j] = 1;
                else if (gap == 1)
                    dp[i][j] = str.charAt(i) == str.charAt(j) ? 2 : 0;
                else
                    dp[i][j] = str.charAt(i) == str.charAt(j) && dp[i + 1][j - 1] != 0 ? dp[i + 1][j - 1] + 2 : 0;

                if (dp[i][j] > len) {
                    len = dp[i][j];
                    si = i;
                }

                if (dp[i][j] != 0)
                    count++;
            }
        }

        return str.substring(si, si + len);
    }
    
 }