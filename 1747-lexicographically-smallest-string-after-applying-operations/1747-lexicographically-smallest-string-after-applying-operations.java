class Solution {
    private String smallest;
    public String findLexSmallestString(String s, int a, int b) {
        smallest = s;
        dfs(s, a, b, new HashSet<>());
        return smallest;
    }
    private void dfs(String s, int a, int b, Set<String> seen) {
        if (seen.add(s)) {
            if (smallest.compareTo(s) > 0) {
                smallest = s;
            }
            char[] ca = s.toCharArray();
            for (int i = 1; i < ca.length; i += 2) {
                ca[i] = (char)((ca[i] - '0' + a) % 10 + '0');
            }
            dfs(String.valueOf(ca), a, b, seen);
            dfs(s.substring(b) + s.substring(0, b), a, b, seen);
        }
    }
}