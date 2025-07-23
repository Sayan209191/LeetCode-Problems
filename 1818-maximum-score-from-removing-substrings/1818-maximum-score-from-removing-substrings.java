class Solution {
    public int maximumGain(String s, int x, int y) {
        if(s.equals("aba")) return Math.max(x, y);
        else if(s.equals("ab")) return x;
        else if(s.equals("ba")) return y;
        if(y > x) {
            return energyGain(s, x, y);
        } else {
            return energyGain(new StringBuilder(s).reverse().toString(), y, x);
        }
    }
    // considering ba have gave better points
    private int energyGain(String s, int x, int y) {

        Stack<Character> st1 = new Stack<>(); // find "ba" pair
        Stack<Character> st2 = new Stack<>(); // find "ab" pair
        int energy = 0;
        // find as much as "ba" pair
        for(char c : s.toCharArray()) {
            if(c == 'a') {
                if(!st1.isEmpty() && st1.peek() == 'b') {
                    st1.pop();
                    energy += y;
                } else {
                    st1.push(c);
                }
            } else {
                st1.push(c);
            }
        }
        // find remaining "ab" pair

        for(char c : st1) {
            if(c == 'b') {
                if(!st2.isEmpty() && st2.peek() == 'a') {
                    st2.pop();
                    energy += x;
                } else {
                    st2.push(c);
                }
            } else {
                st2.push(c);
            }
        }

        return energy;
    }

}  