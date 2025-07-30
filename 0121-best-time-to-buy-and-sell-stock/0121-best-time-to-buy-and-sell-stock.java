class Solution {
    public int maxProfit(int[] prices) {
        int currPrice = Integer.MAX_VALUE;
        int profit = 0;
        for(int i=0; i<prices.length; i++) {
            if(currPrice > prices[i]) {
                currPrice = prices[i];
            }else {
                profit = Math.max(profit, prices[i] - currPrice);
            }
        }
        return profit;

    }
}