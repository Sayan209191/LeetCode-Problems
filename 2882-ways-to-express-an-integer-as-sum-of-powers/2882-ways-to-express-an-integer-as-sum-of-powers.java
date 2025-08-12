class Solution {
    private final int MOD = (int) 1e9 + 7;
    public int numberOfWays(int n, int x) {
        long[] dp = new long[n + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            long val = (long) Math.pow(i, x);
            if(val > n) break;
            for (int j = n; j >= val; j--) {
                
                dp[j] = (dp[j] + dp[j - (int) val]) % MOD;
                
            }
        }
        return (int) dp[n];
    }
}