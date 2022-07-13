class Solution {
    public String removeOuterParentheses(String s) {
        StringBuilder str = new StringBuilder();
        int x =0;
        int si = 0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i) == '(')
                x++;
            else
                x--;
            
            if(x==0){
                String temp = s.substring(si+1, i);
                str.append(temp);
                si = i+1;
            }
        }
        
        return str.toString();
      
    }
}