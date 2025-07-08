class Solution {
    public int splitArray(int[] nums, int k) {
        int n = nums.length;
        int maxi = 0;
        int total = 0;

        for(int num : nums) {
            maxi = Math.max(maxi, num);
            total += num;
        }
        if(k == 1) return total; // if only one subarray then minimized largest sum will be total
        int low = maxi, high = total;

        while(low <= high) {
            int mid = low + (high - low) / 2;

            int spilt = countSplit(nums, mid);
            if(spilt > k) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }

    private int countSplit(int nums[], int target) {
        int cnt = 1;
        int currSum = 0;
        for(int num : nums) {
            if(currSum + num <= target) {
                currSum += num;
            }else {
                cnt++;
                currSum = num;
            }
        }
        return cnt;
    }
}