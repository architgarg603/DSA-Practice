class Solution {
    public int minimumLengthEncoding(String[] str) {
        StringBuilder sb = new StringBuilder();
        Arrays.sort(str, (a,b)->{
            return b.length() - a.length();
        });
        
        for(String s : str){
            if(sb.lastIndexOf(s+"#") == -1){
                sb.append(s+"#");
            }
        }
        
        return sb.length();
    }
}