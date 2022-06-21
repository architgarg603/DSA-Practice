class Solution {
    public int jump(int[] nums) {
        
        int [] arr=new int [nums.length];
        arr[arr.length-1]=0;
        for(int i=nums.length-2;i>=0;i--)
        {
            int step=nums[i];
            int min=Integer.MAX_VALUE;
            arr[i] = min;
            for(int j=1;j<=step && i+j<nums.length;j++){
             min=Math.min(min,arr[i+j]);
                
            }
            if(min!=Integer.MAX_VALUE){
                arr[i]=min+1;
            }
        }
        
        // for(int i: arr)System.out.print(i+" ");
        return arr[0];
        }
}