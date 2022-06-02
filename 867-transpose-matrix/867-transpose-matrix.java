class Solution {
    public int[][] transpose(int[][] mat) {
        int[][] ans = new int[mat[0].length][mat.length];
        
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[0].length;j++){
                ans[j][i] = mat[i][j];
            }
        }
        
        return ans;
    }
}