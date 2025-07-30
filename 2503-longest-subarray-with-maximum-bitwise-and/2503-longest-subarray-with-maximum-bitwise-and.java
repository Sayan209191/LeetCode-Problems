class Solution {
    public int longestSubarray(int[] nums) {
        int max=0,count=0,maxcount=0;
        // Find Maximum value in the array
        for(int i=0;i<nums.length;i++){
            max=Math.max(max,nums[i]);
        }
        // Bitwise And -> 1 & 1 -> 1 (Maximum & Maximum = Maximum)
        for(int i=0;i<nums.length;i++){
            if(max==nums[i]){
                count++;
            }
            else{
                maxcount=Math.max(maxcount,count);
                count=0;
            }
        }
        maxcount=Math.max(maxcount,count);
        
        return maxcount == 0 ? 1 : maxcount;
    }
}