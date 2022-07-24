class Solution {
    public boolean searchMatrix(int[][] arr, int tar) {
        int i = arr.length-1;
        int j =0;
        
        while(i>=0 && j <arr[0].length){
            if(arr[i][j] == tar)
                return true;
            else if(arr[i][j] < tar)
                j++;
            else i--;
        }
        
        return false;
        
    }
}