class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int sum1 = 0;
        int sum2 = 0;
        int ans = 0;
        for (int i = 0; i < k; i++) {
            sum1 += cardPoints[i];
        }
        int r = cardPoints.length - 1;
        ans = sum1;
        for (int i = k - 1; i >= 0; i--) {
            sum1 -= cardPoints[i];
            sum2 += cardPoints[r];
            r--;
            ans = Math.max(ans, sum1 + sum2);
        }
        return ans;
    }
}