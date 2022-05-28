class Solution {
    public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        HashMap<String, Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder(s.substring(0,minSize));
        map.put(sb.toString(),1);
        int ans = 0;
        
        for(int i=minSize;i<s.length();i++){
            sb.deleteCharAt(0);
            sb.append(s.charAt(i));
            
            String temp = sb.toString();
            // System.out.println(temp);
            int cnt = cntVariable(temp);
            if(cnt<=maxLetters){
                map.put(temp, map.getOrDefault(temp,0)+1);
                ans = Math.max(ans, map.get(temp));
            }
            
        }
        
        return ans;
        
    }
    
    public int cntVariable(String str){
        int[] freq = new int[26];
        int ans = 0;
        for(int i=0;i<str.length();i++){
            if(freq[str.charAt(i) - 'a']++ == 0)ans++;
        }
        return ans;
    }
}