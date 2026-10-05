class Solution {
    public long maxScore(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;
        long ans = 0;
        int[][] pairs = new int[n][2];
        for(int i = 0; i < n;i++){
            pairs[i][0] = nums1[i];
            pairs[i][1] = nums2[i];
        }
        Arrays.sort(pairs,(a,b) -> Integer.compare(b[1],a[1]));

        PriorityQueue<Integer> min = new PriorityQueue<>();
        long local = 0;
        for(int i = 0; i < n;i++){
            int n1 = pairs[i][0];
            int n2 = pairs[i][1];

            min.offer(n1);
            local += n1;
            if(min.size() > k){
                local -= min.poll();
            }
            if(min.size() == k){
                ans = Math.max(ans,local*n2);
            }
        }
        return ans;
    }
}