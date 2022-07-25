class Solution {
    
    public int solveLeft(int[] arr, int tar){
        int si = 0, ei = arr.length-1;
        
        while(si<=ei){
            int mid = si + (ei-si)/2;
            
            if(arr[mid] == tar){
                if(mid == 0 || (mid - 1 >= 0 && arr[mid-1] != tar))
                    return mid;
            }
            
             if(arr[mid]>= tar){
                ei = mid-1;
             }
            else{
                si = mid+1;
            } 
        }
        
        return -1;
        
    }
    
    public int solveRight(int[] arr, int tar){
        int si = 0, ei = arr.length-1;
        
       while(si<=ei){
            int mid = si + (ei-si)/2;
           if(arr[mid] == tar){
                if(mid+1 == arr.length || (mid+1<arr.length && arr[mid+1] != tar))
                    return mid;
               
           }
            if(arr[mid]<= tar){
                si = mid+1;
            }
            else 
                ei = mid-1;
        }
        return -1;
    }
    
    
    public int[] searchRange(int[] nums, int tar) {
        int left = solveLeft(nums, tar);
        int right = solveRight(nums,tar);
        return new int[]{left,right};
    }
}