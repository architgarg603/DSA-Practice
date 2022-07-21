class Solution {
    public boolean canConstruct(String s, int k) {
        int[] freq = new int[26];
        
        for(int i=0;i<s.length();i++)
            freq[s.charAt(i) - 'a']++;
        
        int even=0, odd = 0;
        
        for(int x : freq){
            even += x/2;
            odd += x%2;
        }
        
        
        
        if(odd>k || (2*even)+odd < k)
            return false;
        
        return true;
        
    }
}