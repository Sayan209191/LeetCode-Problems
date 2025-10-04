class Solution {
    public int maxArea(int[] height) {
        int i=0; 
        int j = height.length - 1;
        int maxWater = 0;
        while(i<j) {
            int water = 0;
            if(height[i] < height[j]) {
                water = height[i] * (j-i);
                i++;
            } else {
                water = height[j] * (j-i);
                j--;
            }

            maxWater = Math.max(maxWater, water);
        }
        return maxWater;
    }
}