class Solution {
    public boolean canChange(String s1, String s2) {
        int i = 0, j=0, n = s1.length(), m = s2.length();
        if(n != m)
            return false;
        
        while(i<n && j<m){
            if(s1.charAt(i) == '_')
                i++;
            else if(s2.charAt(j) == '_')
                j++;
            else if(s1.charAt(i) != s2.charAt(j))
                return false;
            else{
                char x = s1.charAt(i);
                char y = s2.charAt(j);
                
                if(x == 'L' && i<j)
                    return false;
                if(x =='R' && j<i)
                    return false;
                
                i++;
                j++;
                
            }
        }
        
        while(i<n)
            if(s1.charAt(i++) != '_')
                return false;
        
        while(j<m)
            if(s2.charAt(j++) != '_')
                return false;
        
        return true;
    }
}