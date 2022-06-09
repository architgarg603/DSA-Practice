class Solution {
    public int[] twoSum(int[] arr, int tar) {
       int si=0,ei = arr.length-1;
        int sum =0;
        while(si<ei){
            sum = arr[si]+arr[ei];
            if(sum == tar)break;
            if(sum<tar)
                si++;
            else 
                ei--;
        }
          return new int[]{si+1,ei+1};
    }
}