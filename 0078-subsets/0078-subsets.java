class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0)  return result;
        List<Integer> curr = new ArrayList<>();
        helper(nums, 0, curr, result);
        return result;
    }
    private void helper(int[] nums, int idx, List<Integer> curr, List<List<Integer>> result) {
        if (idx == nums.length) {
            result.add(new ArrayList<>(curr));
            return;
        }
        // non pick 
        helper(nums, idx + 1, curr, result);
        // pick
        curr.add(nums[idx]);
        helper(nums, idx + 1, curr, result);
        curr.remove(curr.size() - 1);
        
    }
}