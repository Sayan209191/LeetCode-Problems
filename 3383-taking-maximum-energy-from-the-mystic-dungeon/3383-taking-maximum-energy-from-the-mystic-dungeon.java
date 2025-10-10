class Solution {
    public int maximumEnergy(int[] energy, int k) {
        int n = energy.length;
        
        
        int maxi= Integer.MIN_VALUE;
        for(int i=n-1; i>=n-k; i--) {
            int sum=0;
            for(int j=i; j>=0; j=j-k) {
                sum+=energy[j];
                maxi = Math.max(maxi, sum);
            }
        }
        return maxi;
    }
}
