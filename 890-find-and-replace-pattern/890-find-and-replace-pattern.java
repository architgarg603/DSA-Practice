class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> ans = new ArrayList<>();
        String pat = solve(pattern);
        for(String x : words){
            String temp  = solve(x);
            if(temp.equals(pat))
                ans.add(x);
        }
        
        return ans;
    }
    
    public String solve(String str){
        int cnt = 1;
        StringBuilder sb = new StringBuilder();
        int[] freq = new int[26];
        for(int i=0;i<str.length();i++){
            if(freq[str.charAt(i) - 'a'] == 0){
                freq[str.charAt(i) - 'a'] = cnt;
                sb.append(cnt++);
            }
            else{
                sb.append(freq[str.charAt(i) - 'a']);
                sb.append(".");
            }
        }
        System.out.println(sb.toString());
        return sb.toString();
    }
}