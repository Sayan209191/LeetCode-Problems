class Solution {
    public int maxFrequencyElements(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i],0)+1);
        }
        // find maximum freqency
        int maxFreq = 0;
        for(int freq : map.values()) {
            maxFreq = Math.max(freq, maxFreq);
        }

        int ans = 0;
        for(int freq : map.values()) {
            if(freq == maxFreq) {
                ans += freq;
            }
        }
        return ans;
    }
}