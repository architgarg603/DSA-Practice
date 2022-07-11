class Solution {
    public int balancedString(String str) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i=0;i<str.length();i++)map.put(str.charAt(i),map.getOrDefault(str.charAt(i),0)+1);
        int tar = str.length()/4;
        int req = 0, n =  str.length();
        int ei = 0, si=0;
        
        for(char c : map.keySet()){
            if(map.get(c)>tar)req++;
        }
        if(req == 0)return 0;
        int ans =Integer.MAX_VALUE;
        while(ei<n){
            char ch = str.charAt(ei++);
            map.put(ch, map.get(ch)-1);
            if(map.get(ch) == tar)req--;
            
            while(req == 0){
                ans = Math.min(ans, ei-si);
                char c = str.charAt(si++);
                map.put(c, map.get(c)+1);
                if(map.get(c) > tar)req++;
            }
        }
        
        return ans;
        
        
        
        
    }
}