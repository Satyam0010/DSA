class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int ans = 0;
        int compare = Integer.MAX_VALUE;
        int len = nums.length;
        Arrays.sort(nums);
        for(int i = 0; i < len;i++){
            if(i > 0 && nums[i] == nums[i-1]) continue;
            int j = i+1,k=len-1;
            while(j < k){
                int sum = nums[i]+nums[j]+nums[k];
                int diff = Math.abs(sum-target);
                if(diff < compare){
                    compare = diff;
                    ans = sum;
                }
                if(sum < target) j++;
                else if(sum > target) k--;
                else return sum;
            }
        }
        return ans;
    }
}