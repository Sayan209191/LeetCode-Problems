class Solution {
    public boolean searchMatrix(int[][] mat, int target) {
        int top = 0, right = mat[0].length - 1;

        while(top < mat.length && right >= 0) {
            if(mat[top][right] == target) {
                return true;
            }
            if(mat[top][right] > target) {
                right--;
            }else{
                top++;
            }
        }
        return false;
    }
}