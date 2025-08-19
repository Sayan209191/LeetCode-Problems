class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<>();

        for(int it : nums) {
            int idx = Math.abs(it)-1;

            if(nums[idx] < 0) {
                res.add(idx+1);
            }
            nums[idx] *= -1;
        }
        return res;
    }
}