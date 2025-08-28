class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        util(new StringBuilder(), 0, 0, n, ans);
        return ans;        
    }
    public void util(StringBuilder curr, int open, int close, int n, List<String> ans){
        if(curr.length() == n * 2){
            ans.add(curr.toString());
            return;
        }
        if(open < n){
            curr.append("(");
            util(curr, open + 1, close, n, ans);
            curr.deleteCharAt(curr.length() - 1);
        }
        if(close < open){
            curr.append(")");
            util(curr, open, close + 1, n, ans);
            curr.deleteCharAt(curr.length() - 1);
        }
    }
}