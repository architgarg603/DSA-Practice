class Solution {
    public void moveZeroes(int[] arr) {
        int i=0, ptr = 0, n = arr.length;
        while(i<n){
            if(arr[i] != 0){
                arr[ptr] = arr[i];
                ptr++;
            }
            i++;
        }
        
        for(i=ptr ;i<n;i++)
            arr[i] = 0;
        
        
    }
}