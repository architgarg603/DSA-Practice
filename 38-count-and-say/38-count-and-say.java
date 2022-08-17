class Solution {
    public String countAndSay(int n) {
        if(n == 1)
            return "1";
        
        String recAns = countAndSay(n-1);
        
        return cal(recAns);
        
    }
    
    public String cal(String str){
        int i=0;
        int n = str.length();
        int cnt = 0;
        
        StringBuilder sb = new StringBuilder();
        while(i<n){
            cnt = 1;
            while(i<n-1 && str.charAt(i) == str.charAt(i+1)){
                i++;
                cnt++;
            }
            sb.append(cnt+""+str.charAt(i));
            i++;
        }
        
        return sb.toString();
    }
}