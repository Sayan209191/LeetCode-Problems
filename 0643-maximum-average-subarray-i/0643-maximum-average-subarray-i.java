class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int n = nums.length;
        int prefix[] = new int[n];
        prefix[0] = nums[0];
        for(int i=1; i<n; i++) {
            prefix[i] = prefix[i-1] + nums[i];
        }

        double maxAverage = prefix[k-1] * 1.0 / k;

        for(int i=k; i<n; i++) {
            double average = (prefix[i] - prefix[i-k]) * 1.0 / k;
            maxAverage = Math.max(average, maxAverage);
        }

        return maxAverage;
    }
}