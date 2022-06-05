class NumMatrix {
   int[][] sum = null;
    public NumMatrix(int[][] mat) {
        int n = mat.length, m = mat[0].length;
        sum = new int[n+1][m+1];
        
        for(int i=1;i<=mat.length;i++){
            for(int j=1;j<=mat[0].length;j++){
                sum[i][j] = mat[i-1][j-1] + sum[i-1][j] + sum[i][j-1] - sum[i-1][j-1];
            }
        }
        
        
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        return sum[row2+1][col2+1] - sum[row2+1][col1] - sum[row1][col2+1] + sum[row1][col1];
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */