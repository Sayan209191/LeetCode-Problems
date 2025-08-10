class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums); // sort to handle duplicates
        boolean[] used = new boolean[nums.length];
        helper(nums, new ArrayList<>(), res, used);
        return res;
    }

    private void helper(int[] nums, List<Integer> temp, List<List<Integer>> res, boolean[] used) {
        if (temp.size() == nums.length) {
            res.add(new ArrayList<>(temp));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            // Skip already used elements
            if (used[i]) continue;

            // Skip duplicates: if nums[i] == nums[i-1] and nums[i-1] wasn't used in this path
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) continue;

            used[i] = true;
            temp.add(nums[i]);

            helper(nums, temp, res, used);

            // backtrack
            used[i] = false;
            temp.remove(temp.size() - 1);
        }
    }
}
