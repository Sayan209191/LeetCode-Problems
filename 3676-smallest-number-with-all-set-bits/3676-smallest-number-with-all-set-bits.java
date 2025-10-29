class Solution {
    public int smallestNumber(int n) {
        if(n == 0|| n == 1) return 1;
        int ans = -1;
        for(int i=1; i<11; i++) {
            if(n == Math.pow(2, i)) {
                ans = (int) Math.pow(2, i+1) -1;
                break;
            }
            if(n > Math.pow(2, i-1) && n < Math.pow(2, i)) {
                ans = (int) Math.pow(2, i) - 1;
                break;
            }
        }
        return ans;
    }
}