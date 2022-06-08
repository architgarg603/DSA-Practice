class Solution {
    public int removePalindromeSub(String s) {
        if(s.length() == 0)return 0;
        int check = 1;
        int si = 0, ei=s.length()-1;
        
        while(si<ei){
            if(s.charAt(si++) != s.charAt(ei--)){
                check = -1;
                break;
            }            
        }
        
        return check == 1 ? 1 : 2;
    }
}