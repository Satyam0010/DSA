class Solution {
    private int[][] memo;
    private static final int INF = 1_000_000;

    public int minOperations(int[] nums, int sum) {
        int n = nums.length;
        memo = new int[n][sum + 1];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }
        int result = find(nums, 0, sum);
        return result == INF ? -1 : result;
    }

    private int find(int[] nums, int index, int rem) {
        if (rem == 0)
            return 0;
        if (index == nums.length)
            return INF;
        if (memo[index][rem] != -1)
            return memo[index][rem];
        int num = nums[index];
        int result = INF;
        result = find(nums, index + 1, rem);
        int temp1 = num;
        int cost = 0;
        while (temp1 > 0) {
            if (temp1 <= rem) {
                int ans = find(nums, index + 1, rem - temp1);
                if (ans != INF)
                    result = Math.min(cost+ans, result);
            }
            temp1 /= 2;
            cost++;
        }

        long multiply = (long) nums[index] * 2;
        cost = 1;
        while (multiply <= rem) {
            int value = (int) multiply;
            int ans = find(nums, index + 1, rem - value);
            if (ans != INF)
                result = Math.min(cost+ans, result);
            multiply *= 2;
            cost++;
        }
        return memo[index][rem] = result;
    }
}