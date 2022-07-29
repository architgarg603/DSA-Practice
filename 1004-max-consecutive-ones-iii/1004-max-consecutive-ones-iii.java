class Solution {
    public int longestOnes(int[] arr, int k) {
        int si=0,ei=0,cnt=0,ans=0,n=arr.length;
        while(ei<n){
            if(arr[ei++] == 0)cnt++;
            while(cnt>k){
                if(arr[si++]==0)cnt--;
            }
            ans= Math.max(ans, ei-si);
        }
        return ans;
    }
}