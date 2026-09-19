class Solution {
    public int findMinMoves(int[] machines) {
        int length = machines.length;
        int sum = 0;
        for (int num : machines) {
            sum += num;
        }
        if (sum % length != 0)
            return -1;
        int target = sum / length;
        int ans = 0;
        int currSum = 0;
        for (int i = 0; i < length; i++) {
            int difference = machines[i] - target;
            currSum += difference;
            ans = Math.max(ans, Math.max(Math.abs(currSum), difference));
        }
        return ans;
    }
}