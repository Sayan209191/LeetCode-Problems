class Solution {
    public boolean backspaceCompare(String s, String t) {
        int i = s.length() - 1, j = t.length() - 1;

        while (i >= 0 || j >= 0) {
            i = getNextValidCharIndex(s, i);
            j = getNextValidCharIndex(t, j);

            // Compare characters
            if (i >= 0 && j >= 0) {
                if (s.charAt(i) != t.charAt(j)) return false;
            } else {
                // One string is exhausted before the other
                if (i >= 0 || j >= 0) return false;
            }

            i--; j--;
        }

        return true;
    }

    private int getNextValidCharIndex(String str, int index) {
        int backspace = 0;
        while (index >= 0) {
            if (str.charAt(index) == '#') {
                backspace++;
            } else {
                if (backspace > 0) {
                    backspace--;
                } else {
                    break;
                }
            }
            index--;
        }
        return index;
    }

}