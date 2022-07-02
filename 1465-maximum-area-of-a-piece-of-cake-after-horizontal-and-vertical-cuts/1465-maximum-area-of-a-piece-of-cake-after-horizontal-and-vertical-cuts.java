class Solution {
    public int maxArea(int hi, int w, int[] hc, int[] vc) {
        Arrays.sort(hc);
        Arrays.sort(vc);
        long v = vc[0];
        
        for(int i=1;i<vc.length;i++)v = Math.max(v, vc[i] - vc[i-1]);
        v = Math.max(v,w - vc[vc.length-1]);
        
        long h = hc[0];
        for(int i=1;i<hc.length;i++)h = Math.max(h, hc[i] - hc[i-1]);
        h = Math.max(h,hi - hc[hc.length-1]);
        
        long mod =(long) 1e9+7;
        return (int)((v*h)%mod);

    }
}