class Solution {
    public int numberOfSubstrings(String s) {
        int n = s.length();
        int[] p = new int[n + 1];
        for (int i = 0; i < n; i++) {
            p[i + 1] = p[i] + (s.charAt(i) == '1' ? 1 : 0);
        }

        int[] dp = new int[n + 1];
        for (int i = n - 1; i >= 0; i--) {
            if (s.charAt(i) == '1') {
                dp[i] = 1 + dp[i + 1];
            } else {
                dp[i] = 0;
            }
        }

        int res = 0;
        int i = 0;
        while (i < n) {
            int ctr = 1;
            while (i < n - 1 && s.charAt(i) == s.charAt(i + 1)) {
                ctr++;
                i++;
            }
            if (s.charAt(i) == '1') {
                res += ctr * (ctr + 1) / 2;
            }
            i++;
        }

        for (int z = 1; z <= n - p[n] && z * z <= p[n]; z++) {
            int j = 0;
            for (i = 0; i < n; i++) {
                j = Math.max(j, i);
                while (j < n && (j - i + 1) - (p[j + 1] - p[i]) < z) {
                    j++;
                }
                if (j == n) {
                    break;
                }
                int ones = p[j + 1] - p[i];
                int lower = Math.max(z * z - ones, 0);
                res += Math.max(dp[j + 1] - lower + 1, 0);
            }
        }

        return res;
    }
}
