class Solution {
    public int maximumUniqueSubarray(int[] arr) {
       int[] freq = new int[(int)(1e4+5)];
        int si =0,ei=0,req=0;
        int n = arr.length;
        int ans=0, temp=0;
        while(ei<n){
            temp+= arr[ei];
            if(freq[arr[ei++]]++ == 1)req++;
            while(req > 0){
                temp -= arr[si];
                if(freq[arr[si++]]-- == 2)req--;
            }
            ans = Math.max(ans,temp);
        }
        return ans;
    }
}