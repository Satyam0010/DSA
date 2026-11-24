
class Solution {
    public int maxLength(int[] nums) {
        int n = nums.length;
        int ans = 0;

        for (int i = 0; i < n; i++) {
            long prod = 1, lcm = 1, g = 0;

            for (int j = i; j < n; j++) {
                prod *= nums[j];
                g = gcd(g, nums[j]);
                lcm = lcm / gcd(lcm, nums[j]) * nums[j];

                if (prod > 25200) break;

                if (prod == lcm * g) {
                    ans = Math.max(ans, j - i + 1);
                }
            }
        }

        return ans;
    }

    private long gcd(long a, long b) {
        while (b != 0) {
            long t = b;
            b = a % b;
            a = t;
        }
        return a;
    }
}