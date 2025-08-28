class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        helper(0, candidates, target, new ArrayList<>(), res);
        return res;
    }

    public void helper(int idx, int arr[], int target, List<Integer> temp, List<List<Integer>> res) {
        if(idx == arr.length) {
            if(target == 0) {
                res.add(new ArrayList<>(temp));
            }
            return;
        }

        if(arr[idx] <= target) {
            temp.add(arr[idx]);
            helper(idx, arr, target-arr[idx], temp, res);
            temp.remove(temp.size()-1);
        }
        helper(idx+1, arr, target, temp, res);
    }
}