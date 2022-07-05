class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0)return 0;
        HashSet<Integer> map = new HashSet<>();
        for(int x : nums)map.add(x);
        
        int ans = 1;
        for(int x : nums){
            if(!map.contains(x-1)){
                int temp = 0;
                int t=x;
                while(map.contains(t++))temp++;
                ans = Math.max(ans,temp);
            }
        }
        
        return ans;
        
        
    }
}