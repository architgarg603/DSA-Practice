class Solution {
    public void setZeroes(int[][] arr) {
        int n = arr.length, m = arr[0].length;
        int[] rowCheck = new int[n];
        int[] colCheck = new int[m];
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(arr[i][j] == 0){
                    rowCheck[i] = 1;
                    colCheck[j] = 1;
                }
            }
        }
        
        for(int i=0;i<n;i++)
            if(rowCheck[i] == 1)
                makeRowZero(arr,i);
        
        for(int i=0;i<m;i++)
            if(colCheck[i] == 1)
                makeColZero(arr,i);
    }
    
    public void makeRowZero(int[][] arr, int row){
        for(int i=0;i<arr[0].length;i++)
            arr[row][i] = 0;
    }
    public void makeColZero(int[][] arr, int col){
        for(int i=0;i<arr.length;i++)
            arr[i][col] = 0;
    }
}