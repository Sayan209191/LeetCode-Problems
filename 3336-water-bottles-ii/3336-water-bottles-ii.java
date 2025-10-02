class Solution {
    public int maxBottlesDrunk(int numBottles, int numExchange) {
        int ans = numBottles;
        int empty = numBottles;
        int full = 0;
        
        while(!(empty < numExchange)) {
            full += 1;
            empty -= numExchange;
            numExchange++;
            if(empty < numExchange && (empty + full) >= numExchange) {
                ans += full;
                empty += full;
                full = 0;
            }else if(empty < numExchange) {
                ans += full;
            }
        }
        return ans;
    }
}