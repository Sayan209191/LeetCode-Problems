class Solution {
    public List<String> letterCombinations(String digits) {
        int n = digits.length();
        List<String> res = new ArrayList<>();
        if(n==0) {
            return res;
        }

        String[] map= {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        helper(0, n, digits, map, new StringBuilder(""), res);
        return res;
    }
    private void helper(int idx, int n, String digits, String map[], StringBuilder output, List<String> res) {
        if(idx == n) {
            res.add(output.toString());
            return;
        }
        int i = digits.charAt(idx) - '0';
        String str = map[i];

        for(int k=0; k<str.length(); k++) {
            output .append(str.charAt(k));
            helper(idx+1, n, digits, map, output, res);
            output = output.deleteCharAt(output.length()-1);
        } 
    } 
}