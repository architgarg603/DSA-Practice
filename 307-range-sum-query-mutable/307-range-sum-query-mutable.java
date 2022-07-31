class NumArray {
      int[] nums;
    int len;
    int sum = 0;
    public NumArray(int[] nums) {
        this.nums = nums;
        len = nums.length;
        for (int i=0; i<len; i++) {
            sum += nums[i];
        }
    }

    public void update(int index, int val) {
        sum -= nums[index];
        nums[index] = val;
        sum += val;
    }

    public int sumRange(int left, int right) {
        int res = 0;
        if (right - left > len / 2) {
            int leftSum = 0;
            for (int i=0; i<left; i++) {
                leftSum += nums[i];
            }
            int rightSum = 0;
            for (int i=right+1; i<len; i++) {
                rightSum += nums[i];
            }
            res = sum - leftSum - rightSum;
        } else {
            for (int i=left; i<=right; i++) {
                res += nums[i];
            }
        }
        return res;
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */