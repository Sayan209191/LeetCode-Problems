class Solution {
    public int maxFrequency(int[] nums, int k, int numOperations) {
        int maxNum = Arrays.stream(nums).max().orElse(0);
        int size = maxNum + k + 2;
        int[] freq = new int[size];

        // Build the frequency array
        for (int num : nums) {
            freq[num] += 1;
        }

        // Build the prefix sum array
        int[] pre = new int[size];
        pre[0] = freq[0];
        for (int i = 1; i < size; ++i) {
            pre[i] = pre[i - 1] + freq[i];
        }

        int result = 0;

        // Iterate through possible values of x
        for (int x = 0; x < size; ++x) {
            if (freq[x] == 0 && numOperations == 0) {
                continue;
            }
            int left = Math.max(0, x - k);
            int right = Math.min(size - 1, x + k);
            int totalInRange = pre[right] - (left > 0 ? pre[left - 1] : 0);
            int canAdjust = totalInRange - freq[x];
            int total = freq[x] + Math.min(numOperations, canAdjust);

            result = Math.max(result, total);
        }

        return result;
    }
}