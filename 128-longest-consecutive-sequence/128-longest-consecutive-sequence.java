class Solution {
    public int longestConsecutive(int[] nums) {
         HashMap<Integer,Integer> map = new HashMap<>();
        
        for(int x : nums){
            map.put(x,1);
        }
        
        int ans=0;
        for(int x : nums){
            if(map.containsKey(x) && !map.containsKey(x-1)){
                int l=0;
                
                while(map.containsKey(x)){
                    x++;
                    l++;
                }
                ans = Math.max(l,ans);
            }   
        }
        return ans;
        
        
    }
}