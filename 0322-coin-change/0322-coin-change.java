class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int dp[][] = new int[n][amount+1];

        for(int row[] : dp) {
            Arrays.fill(row, -1);
        }
        int res =  helper(n-1, coins, amount, dp);

        if(res == (int)1e9) return -1;
        return res;
    }

    private int helper(int idx, int[] arr, int amount, int dp[][]) {
        if(idx == 0) {
            if(amount % arr[0] == 0) {
                return amount / arr[0];
            } else {
                return (int)1e9;
            }
        }

        if(dp[idx][amount] != -1) {
            return dp[idx][amount];
        } 
        int notpick = 0 + helper(idx-1, arr, amount, dp);
        int pick = Integer.MAX_VALUE;
        if(arr[idx] <= amount) {
            pick = 1 +  helper(idx, arr, amount-arr[idx], dp);
        }

        return dp[idx][amount] = Math.min(pick, notpick);
    }
}