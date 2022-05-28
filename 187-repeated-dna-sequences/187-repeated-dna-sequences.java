class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        if(s.length() < 10)return new ArrayList<>();
        
        List<String> ans = new ArrayList<>();
        
        HashMap<String, Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder(s.substring(0,10));
        
        map.put(sb.toString(),1);
        
        for(int i=10 ;i<s.length();i++){
            sb.deleteCharAt(0);
            sb.append(s.charAt(i));
            String temp = sb.toString();
            map.put(temp, map.getOrDefault(temp,0)+1);
            
            if(map.get(temp)==2)ans.add(temp);
            
        }
        
        return ans;
        
        
    }
}