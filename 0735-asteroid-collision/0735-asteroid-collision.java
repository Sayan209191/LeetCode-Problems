class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        
        Stack<Integer> st = new Stack<>();

        for (int asteroid : asteroids) {
            boolean isAlive = true; // Track if the current asteroid is still moving
            while (isAlive && !st.isEmpty() && st.peek() > 0 && asteroid < 0) {
                int top = st.peek();
                if (Math.abs(top) < Math.abs(asteroid)) {
                    st.pop(); // Pop the stack if the top asteroid is smaller and gets destroyed
                } else if (Math.abs(top) == Math.abs(asteroid)) {
                    st.pop(); // Both asteroids are destroyed
                    isAlive = false; // Current asteroid is also destroyed
                } else {
                    isAlive = false; // Current asteroid is destroyed
                }
            }
            if (isAlive) {
                st.push(asteroid); // Only push the asteroid to stack if it is still alive
            }
        }

        // Convert the stack to an array in the correct order
        int[] res = new int[st.size()];
        for (int i = res.length - 1; i >= 0; i--) {
            res[i] = st.pop();
        }
        return res;
    }
}