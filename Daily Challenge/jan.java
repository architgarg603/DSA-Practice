class jan {

    public int findJudge(int n, int[][] arr) {
        int[] freq = new int[n+1];
        int[] freqCnt = new int[n+1];
        for(int i=0;i<arr.length;i++){
            freq[arr[i][0]] = 1;
            freqCnt[arr[i][1]] += 1;
        }
        
        for(int i=1;i<n+1;i++){
            System.out.println(freq[i]);
            if(freq[i]==0 && freqCnt[i] == n-1)return i;
        }
        
        return -1;
    }
    // ===========================leetcode 1009
     public int bitwiseComplement(int n) {
               
        int i = 1;
        
        while(i<n){
            i = i*2 + 1;
        }
        
        return i-n;
    }

    // ========================= leetcode 131
    public List<List<String>> partition(String s) {
        int n = s.length();
         List<List<String>> ans = new ArrayList<>();
         List<String> temp = new ArrayList<>();
         palindromicSubString(s,0, ans, temp);
        return ans;
    }
    
    public static boolean checkPalindrome(String str, int si , int ei){
        while(si<ei){
            if(str.charAt(si++)!=str.charAt(ei--))return false;
        }
        
        return true;
    }
    
    public static void palindromicSubString(String str, int si, List<List<String>> ans, List<String> temp  ){
        
        if(si==str.length()){
            ans.add(new ArrayList<>(temp));
            return;
        }
        
        for(int i=si;i<str.length();i++){
            if(checkPalindrome(str,si,i)){
                temp.add(str.substring(si,i+1));
                palindromicSubString(str,i+1,ans,temp);
                temp.remove(temp.size()-1);
            }
        }
        
    }
    // =======================================================

}