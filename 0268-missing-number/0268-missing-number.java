class Solution {
    public int missingNumber(int[] nums) {
        // int n = nums.length;
        // long totalSum = (n * (n + 1)) / 2;
        // long sum = 0;
        // for(int num : nums) {
        //     sum += num;
        // }

        // return (int) (totalSum - sum);

        int xor = 0;
        int n = nums.length;

        for(int i=0; i<n; i++) {
            xor ^= i;
            xor ^= nums[i];
        }
        return xor ^ n;
    }
}