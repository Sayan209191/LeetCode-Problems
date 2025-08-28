class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        helper(1, n, k, new ArrayList<>(), res);
        return res;
    }
    private void helper(int st, int end, int k, List<Integer> temp, List<List<Integer>> list) {

        // Base case - if k number choose then return that list
        if(temp.size() == k) {
            list.add(new ArrayList<>(temp));
            return;
        }

        for(int i=st; i<=end; i++) {
            temp.add(i);
            helper(i+1, end, k, temp, list);
            temp.remove(temp.size() - 1);
        }

    }
}