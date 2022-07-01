class Solution {
    public int maximumUnits(int[][] arr, int tar) {
        Arrays.sort(arr, (a,b)->{
            return b[1] - a[1];
        });
        
        int ans = 0;
        for(int i=0;i<arr.length;i++){
            // System.out.println()
            int a = Math.min(arr[i][0], tar);
            tar -= a;
            ans += a*arr[i][1];
        }
        
        return ans;
    }
}