class Solution {
    public void merge(int[] n1, int m, int[] n2, int n) {
        int idx = n1.length-1;
        m--;
        n--;
        
        while(n>=0 && m>=0 ){
            if(n1[m] > n2[n]){
                n1[idx--] = n1[m--];
            }else{
                n1[idx--] = n2[n--];
            }
        }
        while(n>=0 ){
                n1[idx--] = n2[n--];
        }
        while(m>=0 ){
                n1[idx--] = n1[m--];
        }
        
    }
}