class Solution {
    public int[] sumAndMultiply(String s, int[][] queries) {
        int mod = 1_000_000_007;
        int n = s.length();

        List<Integer> digits = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int d = s.charAt(i) - '0';
            if (d != 0) digits.add(d);
        }

        int m = digits.size();

        long[] prefSum = new long[m + 1];
        for (int i = 0; i < m; i++) {
            prefSum[i + 1] = (prefSum[i] + digits.get(i)) % mod;
        }

        long[] prefNum = new long[m + 1];
        for (int i = 0; i < m; i++) {
            prefNum[i + 1] = (prefNum[i] * 10 + digits.get(i)) % mod;
        }

        long[] pow10 = new long[m + 1];
        pow10[0] = 1;
        for (int i = 1; i <= m; i++) {
            pow10[i] = (pow10[i - 1] * 10) % mod;
        }

        int[] map = new int[n];
        int idx = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) != '0') {
                map[i] = idx++;
            } else {
                map[i] = -1;
            }
        }

        int q = queries.length;
        int[] ans = new int[q];

        for (int i = 0; i < q; i++) {
            int l = queries[i][0];
            int r = queries[i][1];

            while (l <= r && s.charAt(l) == '0') l++;
            if (l > r) {
                ans[i] = 0;
                continue;
            }

            int left = map[l];

            while (r >= l && s.charAt(r) == '0') r--;
            int right = map[r];

            int len = right - left + 1;

            long x = (prefNum[right + 1] -
                    (prefNum[left] * pow10[len]) % mod + mod) % mod;

            long sum = (prefSum[right + 1] - prefSum[left] + mod) % mod;

            ans[i] = (int)((x * sum) % mod);
        }

        return ans;
    }
}