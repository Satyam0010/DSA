class Solution {
    public long totalCost(int[] costs, int k, int candidates) {
        PriorityQueue<int[]> pqStarting = new PriorityQueue<>(
                (a, b) -> a[0] != b[0] ? Integer.compare(a[0], b[0]) : Integer.compare(a[1], b[1]));
        PriorityQueue<int[]> pqEnding = new PriorityQueue<>(
                (a, b) -> a[0] != b[0] ? Integer.compare(a[0], b[0]) : Integer.compare(a[1], b[1]));
        int n = costs.length;
        int left = candidates;
        int right = n - 1 - candidates;
        for (int i = 0; i < candidates; i++) {
            pqStarting.offer(new int[] { costs[i], i });
            if (n - 1 - i >= candidates)
                pqEnding.offer(new int[] { costs[n - 1 - i], n - 1 - i });
        }
        long ans = 0;
        for (int i = 0; i < k; i++) {
            int startingCandidate = pqStarting.isEmpty() ? Integer.MAX_VALUE : pqStarting.peek()[0];
            int endingCandidate = pqEnding.isEmpty() ? Integer.MAX_VALUE : pqEnding.peek()[0];
            if (startingCandidate < endingCandidate){
                ans += pqStarting.poll()[0];
                if(left <= right) pqStarting.offer(new int[]{costs[left],left++});
            }
                
            else if (startingCandidate > endingCandidate){
                ans += pqEnding.poll()[0];
                if(left <= right) pqEnding.offer(new int[]{costs[right],right--});
            }
            else {
                int startingIndex = pqStarting.isEmpty() ? Integer.MAX_VALUE : pqStarting.peek()[1];
                int endingIndex = pqEnding.isEmpty() ? Integer.MAX_VALUE : pqEnding.peek()[1];
                if (startingIndex < endingIndex){
                    ans += pqStarting.poll()[0];
                    if(left <= right) pqStarting.offer(new int[]{costs[left],left++});
                }
                else{
                    ans += pqEnding.poll()[0];
                    if(left <= right) pqEnding.offer(new int[]{costs[right],right--});
                }
            }
        }
        return ans;
    }
}