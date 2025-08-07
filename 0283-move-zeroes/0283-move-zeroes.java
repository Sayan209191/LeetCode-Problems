class Solution {
    public void moveZeroes(int[] nums) {
        // Find First Zero Index
        int zero = -1;
        for(int i=0; i<nums.length; i++) {
            if(nums[i] == 0) {
                zero = i;
                break;
            }
        }
        if(zero == -1) return;

        // Swap no zero with zero
        for(int i=zero+1; i<nums.length; i++) {
            if(nums[i] != 0) {
                swap(i, zero, nums);
                zero++;
            }
        }

    }
    private void swap(int i, int j, int nums[]) { // ith have non zero, jth have zero
        nums[j] = nums[i];
        nums[i] = 0;
    }
}