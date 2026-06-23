class Solution {
    public int zigZagArrays(int n, int l, int r) {
        int MOD = 1000000007;
        int m = r - l + 1;
        long[][] dp = new long[m][2];
        for (int x = 0; x < m; x++) {
            dp[x][0] = x; 
            dp[x][1] = m - 1 - x; 
        }
        for (int i = 3; i <= n; i++) {
            long[][] nextDp = new long[m][2];
            long[] pref = new long[m];
            long[] suff = new long[m];
            pref[0] = dp[0][1];
            for (int x = 1; x < m; x++) {
                pref[x] = (pref[x - 1] + dp[x][1]) % MOD;
            }
            suff[m - 1] = dp[m - 1][0];
            for (int x = m - 2; x >= 0; x--) {
                suff[x] = (suff[x + 1] + dp[x][0]) % MOD;
            }
            for (int x = 0; x < m; x++) {
                if (x > 0) {
                    nextDp[x][0] = pref[x - 1];
                }
                if (x < m - 1) {
                    nextDp[x][1] = suff[x + 1];
                }
            }
            dp = nextDp;
        }
        long total = 0;
        for (int x = 0; x < m; x++) {
            total = (total + dp[x][0] + dp[x][1]) % MOD;
        }
        return (int) total;
    }
}