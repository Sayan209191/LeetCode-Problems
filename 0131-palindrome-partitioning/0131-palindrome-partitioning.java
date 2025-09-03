class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        helper(0, s, new ArrayList<>(), ans);
        return ans;
    }

    public void helper(int idx, String s, List<String> path, List<List<String>> ans) {
        if(idx == s.length()) {
            ans.add(new ArrayList<>(path));
            return;
        }

        for(int i=idx; i<s.length(); i++) {
            if(isPalindrome(s, idx, i)) {
                path.add(s.substring(idx, i+1));
                helper(i+1, s, path, ans);
                path.remove(path.size()-1);
            }
        }
    }
    public boolean isPalindrome(String s, int start, int end) {
        while(start <= end) {
            if(s.charAt(start++) != s.charAt(end--)) {
                return false;
            }
        }
        return true;
    }
}