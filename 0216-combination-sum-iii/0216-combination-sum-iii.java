class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        helper(1, 0, k, n, new ArrayList<>(), ans);
        return ans;
    }
    public void helper(int st, int count, int k, int target, ArrayList<Integer> temp, List<List<Integer>> ans) {
        if(count == k && target == 0) {
            ans.add(new ArrayList<>(temp));
            return;
        }
        if(st > 9){
            return;
        }

        // pick
        if(st <= target) {
            temp.add(st);
            helper(st+1, count+1, k, target-st, temp, ans);
            temp.remove(temp.size()-1);
        }
        // not pick
        helper(st+1, count, k, target, temp, ans);


    }
}