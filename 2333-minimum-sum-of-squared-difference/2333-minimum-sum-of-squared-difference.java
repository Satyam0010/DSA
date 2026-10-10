class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {

        int[] diff = new int[1_00_001];
        int maxDiff = 0;
        for (int i = 0; i < nums1.length; i++) {
            int dif = Math.abs(nums1[i] - nums2[i]);
            diff[dif]++;
            maxDiff = Math.max(maxDiff, dif);
        }
        long K = (long) k1 + k2;
        for (int i = maxDiff; i > 0 && K > 0; i--) {
            if (diff[i] == 0)
                continue;
            long count = Math.min((long) diff[i], K);
            diff[i - 1] += count;
            diff[i] -= count;
            K -= count;
        }
        long sum = 0;
        for (long i = 1; i <= maxDiff; i++) {
            if (diff[(int)i] > 0) {
                sum += (long) diff[(int)i] * i * i;
            }
        }
        return sum;
    }
}