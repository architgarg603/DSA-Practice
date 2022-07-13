class Solution {
    public int longestPalindrome(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        
        for(int i=0;i<s.length();i++){
            char x = s.charAt(i);
            map.put(x, map.getOrDefault(x,0)+1);
        }
        
        int ans = 0;
        int check = 0;
        
        for(char x : map.keySet()){
            int r = map.get(x)%2;
            int val = map.get(x);
            ans += r==0 ? val : val-1 ;
            check += r ;
        }
        System.out.println(ans+" "+check);
        return check == 0 ? ans : ans + 1;
    }
}