class Solution {
    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);
        if(costs[0] > coins) return 0;

        int currSpend = 0;
        int res = 0;

        for(int i=0; i<costs.length; i++) {
            if(currSpend + costs[i] <= coins){
                currSpend += costs[i];
                res++;
            }
            else break;
        }

        return res;
        
    }
}