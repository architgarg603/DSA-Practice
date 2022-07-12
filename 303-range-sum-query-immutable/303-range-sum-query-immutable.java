class NumArray {
    int[] sum = null;
    public NumArray(int[] arr) {
        sum = new int[arr.length];
        int x = 0;
        for(int i=0;i<arr.length;i++){
            x += arr[i];
            sum[i] = x;
        }
    }
    
    public int sumRange(int left, int right) {
        // System.out.println( sum[right]+ " "+ (left == 0 ? 0 : sum[left - 1]));
        return  sum[right] - (left == 0 ? 0 : sum[left - 1]);
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */