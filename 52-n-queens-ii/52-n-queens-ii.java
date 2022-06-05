class Solution {
    public int totalNQueens(int n) {
        int r=0, ld=0,rd=0;
        return solve(n,r,ld,rd,0);
    }
    
    public int solve(int n, int r, int ld, int rd, int x){
        if(x==n)return 1;
        int ans =0;
        
        for(int i=0;i<n;i++){
            int mask = (1<<i);
            int lMask = (1<< (x-i+n-1));
            int rMask = (1 << (x+i));
            
            if((mask & r) == 0 && (lMask & ld) == 0 && (rd & rMask) == 0){
                
                r ^= mask;
                ld ^= lMask;
                rd ^= rMask;
                
                ans += solve(n,r,ld,rd,x+1);
                
                 r ^= mask;
                ld ^= lMask;
                rd ^= rMask;
                
            }
        }
        
        return ans;
    }
}