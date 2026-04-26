class Solution {
    public int[] kthRemainingInteger(int[] nums, int[][] queries) {

        List<Integer> evens = new ArrayList<>();
        for (int x : nums) {
            if ((x & 1) == 0) evens.add(x);
        }

        int[] ans = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {

            int l = queries[i][0];
            int r = queries[i][1];
            int k = queries[i][2];

            int L = nums[l], R = nums[r];

            int left = lowerBound(evens, L);
            int right = upperBound(evens, R) - 1;

            long low = 2, high = 2L * (k + (right - left + 2));

            while (low < high) {
                long mid = (low + high) >> 1;

                long total = mid / 2;

                int removed = 0;
                if (left <= right) {
                    int upto = upperBound(evens, (int) mid) - 1;
                    if (upto >= left) {
                        removed = Math.min(upto, right) - left + 1;
                    }
                }

                if (total - removed >= k) high = mid;
                else low = mid + 1;
            }

            ans[i] = (int) low;
        }

        return ans;
    }

    private int lowerBound(List<Integer> a, int x) {
        int l = 0, r = a.size();
        while (l < r) {
            int m = (l + r) >> 1;
            if (a.get(m) >= x) r = m;
            else l = m + 1;
        }
        return l;
    }

    private int upperBound(List<Integer> a, int x) {
        int l = 0, r = a.size();
        while (l < r) {
            int m = (l + r) >> 1;
            if (a.get(m) > x) r = m;
            else l = m + 1;
        }
        return l;
    }
}