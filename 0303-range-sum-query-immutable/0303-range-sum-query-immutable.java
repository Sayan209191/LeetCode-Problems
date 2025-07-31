class NumArray {

    int nums[];
    int prefixNums[];
    public NumArray(int[] nums) {
        this.nums = nums;
        prefixNums = new int[nums.length];
        calculatePrefixSum(nums, prefixNums);
    }

    private void calculatePrefixSum(int nums[], int prefix[]){
        prefix[0] = nums[0];

        for(int i=1; i<nums.length; i++) {
            prefix[i] = prefix[i-1] + nums[i];
        }
    }
    
    public int sumRange(int left, int right) {
        if(left == 0) return prefixNums[right];

        return prefixNums[right] - prefixNums[left-1];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */