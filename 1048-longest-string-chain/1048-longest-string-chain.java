class Solution {
    public int longestStrChain(String[] words) {
        HashMap<String,Integer> map = new HashMap<>();
        HashMap<String,Integer> dp = new HashMap<>();
        int ans = 1;
        for(String x :words)map.put(x,1);
        for(String key : map.keySet()){
            ans = Math.max(ans,dfs(map,dp,key));
        }
        
        return ans;
    }
    
    public int dfs( HashMap<String,Integer> map,  HashMap<String,Integer> dp, String str){
        if(dp.containsKey(str))return dp.get(str);
        int ans = 0;
        StringBuilder sb = new StringBuilder(str);
        for(int i=0;i<str.length();i++){
            sb.deleteCharAt(i);
            String temp =  sb.toString();
            if(map.containsKey(temp)){
                ans = Math.max(ans, dfs(map, dp, temp));
            }
            sb.insert(i, str.charAt(i));
        }
        dp.put(str,ans+1);
        return ans+1;
        
    }
    
    
}