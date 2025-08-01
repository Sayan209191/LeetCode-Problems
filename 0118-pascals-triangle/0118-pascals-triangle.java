class Solution {
    public static List<Integer> getNthRowElements(int row) {
        List<Integer> res = new ArrayList<>();
        int ans = 1;
        res.add(ans);
        for(int i=1; i<row; i++) {
            ans = ans*(row-i); // ans*(row-col)/col
            ans = ans/i;
            res.add(ans);
        }
        return res;
    }
    public List<List<Integer>> generate(int row) {
        List<List<Integer>> res = new ArrayList<>();

        for(int i=1; i<=row; i++) {
            res.add(getNthRowElements(i));
        }
        return res;
    }
}