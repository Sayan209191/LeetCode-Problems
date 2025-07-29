class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> list = new ArrayList<>(); 
        for(int c : nums){
            nums[Math.abs(c)-1] = -Math.abs(nums[Math.abs(c)-1]);   // mark c is present by negating nums[c-1]
        }
        for(int i = 0; i < nums.length; i++) 
            if(nums[i] > 0) list.add(i+1);      // nums[i] > 0 means i+1 isnt present in nums
        return list;
    }
    
}