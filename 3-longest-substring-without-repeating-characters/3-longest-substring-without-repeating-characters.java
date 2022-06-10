class Solution {
    public int lengthOfLongestSubstring(String s) {
       int[] freq = new int[128];
        int si=0,ei=0, n =s.length();
        int req = 0;
        int ans = 0;
        while(ei<n){
            if(freq[s.charAt(ei++)]++ == 1 ){
                req++;
            }
            
            while(req > 0){
                if(freq[s.charAt(si++)]-- == 2)req--;
            }
            ans = Math.max(ans, ei-si);
        }
        return ans;
    }
}