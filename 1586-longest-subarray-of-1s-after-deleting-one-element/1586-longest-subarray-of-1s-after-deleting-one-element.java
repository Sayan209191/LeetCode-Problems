class Solution {
    public int longestSubarray(int[] nums) {
        int left = 0;
        int right = 0;
        int zeros = 0;
        int maxLen = 0;

        while(right < nums.length) {
            if(nums[right] == 0) zeros++;

            if(zeros > 1) {
                if(nums[left] == 0) zeros--;
                left++;
            } else {
                int len = right-left+1;
                maxLen = Math.max(maxLen, len);
            }

            right++;
            
        }
        return maxLen-1;
    }
}