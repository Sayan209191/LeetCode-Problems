class Solution {
    public List<Integer> replaceNonCoprimes(int[] nums) {
        LinkedList<Integer> res = new LinkedList();
        for (int a : nums) {
            while (true) {
                int last = res.isEmpty() ? 1 : res.getLast();
                int x = gcd(last, a);
                if (x == 1) break; // co-prime
                a *= res.removeLast() / x;
            }
            res.add(a);
        }
        return res;
    }

    public int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}