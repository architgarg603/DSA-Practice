class Solution {
    public long minSumSquareDiff(int[] a1, int[] a2, int k1, int k2) {
        int[] freq= new int[100001];
        int n = a1.length;
        int maxDiff = 0;
        for(int i=0;i<n;i++){
            int diff = Math.abs(a1[i] - a2[i]);
            freq[diff]++;
            maxDiff = Math.max(maxDiff, diff);
            
        }
        
        int t = k1+k2;
        while(maxDiff>0 && t>0){
            int val = Math.min(t, freq[maxDiff]);
            freq[maxDiff-1] += val;
            freq[maxDiff] -= val;
            t -= val;
            if(freq[maxDiff] ==0)maxDiff--;
            
        }
        
        
        long ans = 0;
        for(int i=1;i<=maxDiff;i++){
            ans += ((long)(i)*i*freq[i]);
        }
        
        return ans;
        
    }
}