class Solution {
    public int maxAreaOfIsland(int[][] arr) {
        int ans = 0;
        for(int i =0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                if(arr[i][j]==1)
                    ans = Math.max(ans,solve(arr,i,j));
            }
        }
        
        return ans;
    }
    
    public int solve(int[][] arr, int i, int j){
        if(i<0 || j<0 || i>=arr.length || j>= arr[0].length || arr[i][j] == 0)return 0;
        int ans = 1;
        arr[i][j] = 0;
        ans += solve(arr,i+1,j);
        ans += solve(arr,i,j-1);
        ans += solve(arr,i-1,j);
        ans += solve(arr,i,j+1);
        
        return ans;
    }
}