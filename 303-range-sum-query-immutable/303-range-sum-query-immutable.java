class NumArray {
    int[] sum = null;
    public NumArray(int[] arr) {
        sum = new int[arr.length+1];
        int x = 0;
        for(int i=0;i<arr.length;i++){
            sum[i] = x;
            x += arr[i];
        }
        sum[arr.length] = x;
    }
    
    public int sumRange(int left, int right) {
        return  sum[right+1] - sum[left];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */