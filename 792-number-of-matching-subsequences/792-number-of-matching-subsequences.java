class Solution {
    public int numMatchingSubseq(String s, String[] arr) {
        int ans = 0;
        HashMap<String,Integer> map = new HashMap<>();
        
        for(int i=0;i<arr.length;i++){
            map.put(arr[i],map.getOrDefault(arr[i],0)+1);
        }
        
        for(String str : map.keySet()){
            if(solve(s,str) == 1)ans += map.get(str);
        }
        
        return ans;
    }
    
    public int solve(String str, String tar){
        if(tar.length()> str.length())return 0;
        
        int i=0;
        int j=0;
        
        while(i<str.length() && j< tar.length()){
            if(str.charAt(i) == tar.charAt(j))
                j++;
            i++;
        }
        
        return j == tar.length() ? 1 : 0;
    }
}