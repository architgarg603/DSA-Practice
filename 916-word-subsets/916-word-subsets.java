class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        List<String> ans = new ArrayList<>();
        int[] freq  = new int[26];
        
        for(String str : words2){
            int[] temp = new int[26];
            for(int i=0;i<str.length();i++)
                temp[str.charAt(i) - 'a']++;
            
            for(int i=0;i<26;i++){
                freq[i] = Math.max(freq[i], temp[i]);
            }
        }
        for(String str : words1){
            int[] temp = new int[26];
            for(int i=0;i<str.length();i++)
                temp[str.charAt(i) - 'a']++;
            int check = 1;
            
            for(int i=0;i<26;i++){
                if(temp[i]< freq[i]){
                    check = 0;
                    break;
                }
            }
            
            if(check == 1)
                ans.add(str);
        }
        
        return ans;
        
    }
}