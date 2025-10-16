class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);

        int res[] = new int[spells.length];
        int n = potions.length;
        for (int i = 0; i < spells.length; i++) {
            res[i] = n - search(spells[i], potions, success);
        }
        return res;
    }

    private int search(int spell, int[] potions, long success) {
        int st = 0, end = potions.length - 1, ans = potions.length;

        while (st <= end) {
            int mid = st + (end - st) / 2;
            if ((long) spell * potions[mid] >= success) {
                ans = mid;
                end = mid - 1;
            } else {
                st = mid + 1;
            }
        }
        return ans;
    }
}

