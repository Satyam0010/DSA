class Solution {
    public int maxSelectedElements(int[] nums) {
        Arrays.sort(nums);

        Map<Integer, Integer> dp = new HashMap<>();
        int answer = 1;

        for (int value : nums) {
            dp.put(value + 1, Math.max(dp.getOrDefault(value + 1, 0), dp.getOrDefault(value, 0) + 1));
            dp.put(value, Math.max(dp.getOrDefault(value, 0), dp.getOrDefault(value - 1, 0) + 1));

            answer = Math.max(answer, Math.max(dp.get(value), dp.get(value + 1)));
        }

        return answer;
    }
}