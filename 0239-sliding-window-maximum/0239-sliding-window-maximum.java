class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[n-k+1];
        Deque<Integer> dq = new LinkedList<>();
        for(int iterator = 0; iterator < n; iterator++){
            while(!dq.isEmpty() && dq.peekFirst() <= iterator-k){
                dq.pollFirst();
            }
            while(!dq.isEmpty() && nums[dq.peekLast()] <= nums[iterator]){
                dq.pollLast();
            }
            dq.offer(iterator);
            if(iterator >= k-1){
                ans[iterator-k+1] = nums[dq.peekFirst()];
            }
        }
        return ans;
    }
}