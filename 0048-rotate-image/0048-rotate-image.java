class Solution {
    public void rotate(int[][] arr) {
        int n = arr.length;
        // Step 1 : Transpose of the Matrix
        for(int i=0; i<n-1; i++) {
            for(int j=i+1; j<n; j++) {
                int temp = arr[i][j];
                arr[i][j] = arr[j][i];
                arr[j][i] = temp;
            }
        }
        // Step 2 : Reverse the row
        for(int i=0; i<n; i++) {
            for(int j=0; j<n/2; j++) {
                int temp = 0;
                temp = arr[i][j];
                arr[i][j] = arr[i][arr.length - 1 - j];
                arr[i][arr.length - 1 - j] = temp;
            }
        }
    }
}