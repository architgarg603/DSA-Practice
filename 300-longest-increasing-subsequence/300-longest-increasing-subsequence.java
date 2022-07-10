class Solution {
    public int lengthOfLIS(int[] nums) {
          int n = nums.length;
        // dp[i] = longest increasing subquence from nums[0...i]
        int[] dp = new int[n];

        // base case
        Arrays.fill(dp, 1);

        for (int i = 0; i < n; i++) {
            int longest = 1;
            for (int j = i; j >= 0; j--) {
                if (nums[j] < nums[i]) {
                    longest = Math.max(dp[j] + 1, longest);
                }
            }
            dp[i] = longest;
        }

        int res = 0;
        for (int num : dp) {
            res = Math.max(res, num);
        }
        return res;
    }
}