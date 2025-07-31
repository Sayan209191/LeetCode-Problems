class Solution {
    public int subarrayBitwiseORs(int[] arr) {
        int n = arr.length;
        HashSet<Integer> res = new HashSet<>();
        HashSet<Integer> curr = new HashSet<>();
        HashSet<Integer> next;

        for(int i=0; i<n; i++) {
            int num = arr[i];
            next = new HashSet<>();
            next.add(num);

            for(int prefix : curr) {
                next.add(num | prefix);
            }
            res.addAll(next);
            curr = next;
        }

        return res.size();
    }
}