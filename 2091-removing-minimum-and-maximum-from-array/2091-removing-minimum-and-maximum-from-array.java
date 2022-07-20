class Solution {
    public int minimumDeletions(int[] arr) {
        int x = 0, y=0;
        
        for(int i=0;i<arr.length;i++){
            if(arr[i]<arr[x])x = i;
            if(arr[i]>arr[y])y = i;
        }
        
        int ans = Integer.MAX_VALUE;
        
        ans = Math.min(ans, x+1 + (arr.length-y));
        ans = Math.min(ans, y+1 + (arr.length-x));
        
        int x1 = Math.min(x,y);
        int y1 = Math.max(x,y);
        
        ans = Math.min(ans, y1+1 );
        ans = Math.min(ans, arr.length - x1);
        
        return ans;
        
        
    }
}