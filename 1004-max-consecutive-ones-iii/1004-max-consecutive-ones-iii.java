class Solution {
    public int longestOnes(int[] arr, int k) {
       int si =0, ei=0, cnt = 0, ans = 0;
        int n = arr.length;
        
        while(ei<n){
            if(arr[ei] == 0)cnt++;
            
            while(cnt>k){
                if(arr[si] == 0)cnt--;
                si++;
            }
            
            ans = Math.max(ans, ei-si+1);
            ei++;
        }
        return ans;
    }
        
}