class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int dp[] = new int[n];
        Arrays.fill(dp, 1);
        
        for(int idx = 0; idx<n; idx++) {
            for(int prevIdx = 0; prevIdx < idx; prevIdx++) {
                if(nums[prevIdx] < nums[idx]) {
                    dp[idx] = Math.max(dp[idx], dp[prevIdx]+1);
                }
            }
        }
        int res = -1;
        for(int i=0; i<n; i++) {
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}