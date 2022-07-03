class Solution {
    public int wiggleMaxLength(int[] nums) {
        int[] dp = new int[nums.length+1];
        Arrays.fill(dp,-1);
        int a = solve(nums,dp,0,0);
        Arrays.fill(dp,-1);
        int b = solve(nums,dp,0,1);
        return Math.max(a,b);
    }
    
    public int solve(int[] arr, int[] dp, int idx, int check){
        if(idx == arr.length)return dp[idx] = 0;
        
        if(dp[idx] != -1)return dp[idx];
        
        
        if(check ==1){
            int ans = 0;
            for(int i = idx; i<arr.length;i++){
                if(arr[i]>arr[idx])ans = Math.max(ans, solve(arr,dp,i,0));
            }
            
            return dp[idx] = ans + 1;
        }
        
        int ans = 0;
        for(int i = idx; i<arr.length;i++){
            if(arr[i]<arr[idx])ans = Math.max(ans, solve(arr,dp,i,1));
        }

        return dp[idx] = ans + 1;
        
    }
}