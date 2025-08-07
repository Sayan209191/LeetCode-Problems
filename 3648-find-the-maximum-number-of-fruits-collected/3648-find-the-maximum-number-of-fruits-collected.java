class Solution {
    public int maxCollectedFruits(int[][] fruits) {
        int n = fruits.length;
        int res = 0;
        Integer memo1[][] = new Integer[n][n] ; 
        Integer memo2[][] = new Integer[n][n] ; 
        int stepsLimit = (int)Math.floor(n/2)-2 ; 

        // Diagonal sum
        for (int i = 0; i < n; i++) {
            res += fruits[i][i];
        }
        // Top Right
        res += helper1(0, n-1, fruits, memo1, n, stepsLimit) ; 
        // Buttom Left
        res += helper2(n-1, 0, fruits, memo2, n, stepsLimit) ; 
        return res ;
    }
    public int helper1(int i, int j, int arr[][], Integer memo1[][], int n, int stepsLimit) {
        if(!isValid(i, j, n) || i>=j || (i==n-1 && j==n-1)) {
            return 0 ; 
        }
        if(memo1[i][j]!=null) {
            return memo1[i][j] ; 
        }
        int ans1 = arr[i][j] + helper1(i+1, j, arr, memo1, n, stepsLimit) ; 
        int ans2 = arr[i][j] + helper1(i+1, j-1, arr, memo1, n, stepsLimit-1) ; 
        int ans3 = arr[i][j] + helper1(i+1, j+1, arr, memo1, n, stepsLimit) ; 
        return memo1[i][j] = Math.max(ans1, Math.max(ans2, ans3)) ; 
    }
    public int helper2(int i, int j, int arr[][], Integer memo2[][], int n, int stepsLimit) {
        if(!isValid(i, j, n)||j>=i|| (i==n-1 && j==n-1)) {
            return 0 ; 
        }
        if(memo2[i][j]!=null) {
            return memo2[i][j] ; 
        }
        int ans1 = arr[i][j] + helper2(i, j+1, arr, memo2, n, stepsLimit) ; 
        int ans2 = arr[i][j] + helper2(i-1, j+1, arr, memo2, n, stepsLimit-1) ; 
        int ans3 = arr[i][j] + helper2(i+1, j+1, arr, memo2, n, stepsLimit) ; 
        return memo2[i][j] = Math.max(ans1, Math.max(ans2, ans3)) ; 
    }
    private boolean isValid(int i, int j, int n) {
        return i>=0 && j>=0 && i<n && j<n;
    }
}