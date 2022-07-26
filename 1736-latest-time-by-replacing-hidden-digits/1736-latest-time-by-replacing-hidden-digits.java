class Solution {
    public String maximumTime(String time) {
        String ans = "";
        
        char x = time.charAt(0);
        char y = time.charAt(1);
        
        if(x == '?' && y == '?'){
            ans += "23:";
        }else if(x == '?'){
            if(y > '3'){
                ans += "1"+y+":";
            }else{
                ans += "2"+y+":";
            }
        }else if(y == '?'){
            if(x<'2'){
                ans += x+"9:";
            }else{
                ans += x+"3:";
            }
        }else{
            ans += ""+x+y+":";
        }
        
        x = time.charAt(3);
        y = time.charAt(4);
        
        if(x == '?' && y == '?'){
            ans += "59";
        }else if(x == '?'){
                ans += "5"+y;
        }else if(y == '?'){
                ans += x+"9";
        }else{
            ans += ""+x+y;
        }
        
        
        return ans;
        
        
    }
}