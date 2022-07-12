class Solution {
    public boolean makesquare(int[] arr) {
        int sum = 0;
        for(int i : arr)sum += i;
        
        if(sum ==0 && sum%4 >0)return false;
        int[]  dp = new int[4];
        
        return solve(arr,dp,arr.length-1, sum/4);
    }
    
    public boolean solve(int[] arr, int[] dp, int idx, int tar){
        if(idx == -1){
            return (dp[0] == dp[1]) && (dp[1] == dp[2]) && (dp[2] == dp[3]) && (dp[3] == tar);
        }
        
        for(int i=0;i<4;i++){
            if(dp[i] + arr[idx] <= tar){
                
                int j = i-1;
                while(j>=0 && dp[i] != dp[j])j--;
                if(j>=0)continue;
                
                dp[i] += arr[idx];
                if(solve(arr,dp,idx-1,tar) == true)return true;
                dp[i] -= arr[idx];
            }
        }
        
        return false;
        
    }
}