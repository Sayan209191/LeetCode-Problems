class Solution {
    public int countSquares(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        int prev[] = new int [m];
        int curr[] = new int [m];
        int sum = 0;
   
        for(int j=0; j<m; j++) {
            prev[j] = matrix[0][j];
            sum += matrix[0][j];
        }

        // fill up dp table


        for(int i=1; i<n; i++) {
            curr[0] = matrix[i][0];
            sum += curr[0];
            for(int j=1; j<m; j++) {
                if(matrix[i][j] == 1) {
                    curr[j] = Math.min(prev[j-1] , Math.min(curr[j-1], prev[j])) + 1;
                    sum += curr[j];
                } else {
                    curr[j] = 0;
                }
            }

            prev = curr.clone();
        }

        return sum;
    }
}