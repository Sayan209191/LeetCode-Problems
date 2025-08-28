class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        helper(0, candidates, target, new ArrayList<>(), res);
        return res;
    }
    public void helper(int idx, int arr[], int target, List<Integer> temp, List<List<Integer>> res) {
        if(target == 0) {
            res.add(new ArrayList<>(temp));
            return;
        }
        for(int i=idx; i<arr.length; i++) {
            if (i>idx && arr[i] == arr[i-1]) {
                continue; 
            }
            if (arr[i] > target) break;

            temp.add(arr[i]);
            helper(i+1, arr, target-arr[i], temp, res);
            temp.remove(temp.size()-1);
        }
    }
}