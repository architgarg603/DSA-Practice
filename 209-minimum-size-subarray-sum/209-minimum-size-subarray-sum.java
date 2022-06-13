class Solution {
    public int minSubArrayLen(int tar, int[] arr) {
        int si =0,ei=0, n = arr.length;
        int ans = Integer.MAX_VALUE;
        int temp =0;
        while(ei<n){
            temp += arr[ei++];
            
            while(si<ei && temp>= tar){
                ans = Math.min(ei-si, ans);
                temp -= arr[si++];
            }
        }
        
        return ans == Integer.MAX_VALUE ? 0:ans;
    }
}