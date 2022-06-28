class Solution {
    public int minDeletions(String s) {
        int[] freq = new int[26];
        for(int i=0;i<s.length();i++)freq[s.charAt(i) - 'a']++;
        
        Arrays.sort(freq);
        
        HashSet<Integer> map = new HashSet<>();
        for(int i=0;i<26;i++)
            if(freq[i] != 0)
             map.add(freq[i]);
        int ans = 0;
        for(int i=1;i<26;i++){
            if(freq[i] != 0 && freq[i] == freq[i-1]){
                ans += solve(map, freq[i]);
            }
        }
        
        return ans;
        
    }
    
    public int solve(HashSet<Integer> map , int freq){
        int ans = 0;
        while(map.contains(freq)){
            ans++;
            freq--;
        }
        if(freq>0)
            map.add(freq);
        
        return ans;
    }
}