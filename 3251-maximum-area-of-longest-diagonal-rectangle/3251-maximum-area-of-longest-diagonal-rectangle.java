class Solution {
    public int areaOfMaxDiagonal(int[][] dimensions) {
        double maxDigonal = 0;
        int maxArea = 0;

        for(int dimension[] : dimensions) {
            int len = dimension[0];
            int width = dimension[1];

            double digonal = Math.sqrt((len * len) + (width * width));
            if(digonal > maxDigonal) {
                maxArea = len * width;
                maxDigonal = digonal;
            } else if(digonal == maxDigonal) {
                maxArea = Math.max(maxArea, len * width);
            }
        }
        return maxArea; 
    }
}