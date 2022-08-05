class Solution {
    public int maxProfit(int[] arr) {
        int ans = 0;
        int[] maxArr = new int[arr.length];
        int max = 0;
        
        for(int i = arr.length-1;i>=0;i--){
            max = Math.max(max,arr[i]);
            maxArr[i] = max;
        }
        
        for(int i =0;i<arr.length;i++){
            ans = Math.max(ans, maxArr[i] - arr[i]);
        }
        
        return ans;
        
        
    }
}