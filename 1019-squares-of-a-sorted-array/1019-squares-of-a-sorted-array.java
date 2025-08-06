class Solution {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int res[] = new int[n];

        int i=0, j=n-1, idx = n-1;

        while( i <= j) {
            if(Math.abs(nums[i]) >= Math.abs(nums[j])) {
                res[idx--] = nums[i] * nums[i];
                i++;
            } else {
                res[idx--] = nums[j] * nums[j];
                j--;
            }
        } 
        return res;
        
    }
}