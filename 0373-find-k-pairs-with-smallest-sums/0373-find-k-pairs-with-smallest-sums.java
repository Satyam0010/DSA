class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        if(nums1.length == 0 || nums2.length == 0) return ans;
        PriorityQueue<int[]> q = new PriorityQueue<>((a,b) -> Integer.compare(a[0],b[0]));
        for(int i = 0; i < Math.min(k,nums1.length);i++){
            q.offer(new int[]{nums1[i]+nums2[0],i,0});
        }
        while(!q.isEmpty() && ans.size()<k){
            int[] curr = q.poll();
            int i = curr[1];
            int j = curr[2];
            ans.add(List.of(nums1[i],nums2[j]));
            if(j+1 < nums2.length) q.offer(new int[]{nums1[i]+nums2[j+1],i,j+1});
        }
        return ans;
    }
}