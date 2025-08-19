class Solution {
    public long zeroFilledSubarray(int[] nums) {
        long contCount = 0;    // Count of continuous zeros in current sequence
        long subarrays = 0;    // Total count of zero-filled subarrays
        
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == 0) {
                contCount++;   // Increment count of continuous zeros
            }
            else {
                // Calculate number of zero-filled subarrays for current sequence
                // For a sequence of length n, number of subarrays is n*(n+1)/2
                subarrays += (contCount * (contCount + 1) / 2);
                contCount = 0; // Reset continuous count
            }
        }
        // Handle the case where array ends with zeros
        if(contCount > 0) {
            subarrays += (contCount * (contCount + 1) / 2);
        }
        
        return subarrays;
    }
}