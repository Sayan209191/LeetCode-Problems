class Solution {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int n = nums.length;
        int res[] = new int[n];

        // process
        for(int i=2*n - 1; i>=0; i--) {
            int idx = i%n;
            int currEle = nums[idx];

            while(!stack.isEmpty() && stack.peek() <= currEle) {
                stack.pop();
            }
            // Store result in second half
            if(i < n) {
                if(stack.isEmpty()) res[i] = -1;
                else res[i] = stack.peek();
            }

            stack.push(currEle);
        }
        return res;
    }
}