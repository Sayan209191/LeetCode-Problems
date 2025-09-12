class Solution {
    public boolean doesAliceWin(String s) {
        int cnt = 0;
        Set<Character> st = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o','u'));

        for(char ch : s.toCharArray()) {
            if(st.contains(ch)) cnt++;
        }

        if(cnt == 0) return false;

        return true;
    }
}