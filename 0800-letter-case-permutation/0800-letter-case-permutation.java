class Solution {
    public List<String> letterCasePermutation(String s) {
        List<String> list = new ArrayList<>();
        int n = s.length();
        if(n == 0) return list;

        helper(0, n, s, new StringBuilder(""), list);
        return list;
    }

    private void helper(int idx, int n, String str, StringBuilder sb, List<String> list) {
        if(idx == n) {
            list.add(sb.toString());
            return;
        }
        char c = str.charAt(idx);
        if(Character.isDigit(c)) {
            sb.append(c);
            helper(idx+1, n, str, sb, list);
            sb.deleteCharAt(sb.length() - 1);
        } else {
            // Lowercase branch
            sb.append(Character.toLowerCase(c));
            helper(idx + 1, n, str, sb, list);
            sb.deleteCharAt(sb.length() - 1); 

            // uppercase branch
            sb.append(Character.toUpperCase(c));
            helper(idx + 1, n, str, sb, list);
            sb.deleteCharAt(sb.length() - 1); 
        }
    }
}