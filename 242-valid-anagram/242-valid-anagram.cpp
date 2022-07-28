class Solution {
public:
    bool isAnagram(string s, string t) {
        if(s.size()!=t.size())return false;
         sort(t.begin(), t.end()); 
         sort(s.begin(), s.end()); 
        
        
        return s == t;
        
        
    }
};