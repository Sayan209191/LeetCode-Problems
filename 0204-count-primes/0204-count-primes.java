class Solution {
    public int countPrimes(int n) {
        if(n <= 2) return 0;
        boolean isPrime[] = new boolean[n+1];
        Arrays.fill(isPrime, true);
        ArrayList<Integer> list = new ArrayList<>();

        for(long i=2; i<n; i++) {
            if(isPrime[(int)i]) {
                list.add((int)i);
                for(long val = i*i; val<n; val += i){
                    isPrime[(int)val] = false;
                }
            }
        }

        return list.size();
    }
}