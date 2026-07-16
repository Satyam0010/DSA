class Solution {
    public int maxOperations(int[] nums, int k) {
        int l = nums.length;
        int i = 0,j = l-1,ans = 0;
        Arrays.sort(nums);
        while(i < j){

            if(nums[i]+nums[j] == k){
                ans += 1;
                i++;
                j--;
                continue;
            } else if( nums[i] + nums[j] < k) i++;
            else j--;
        }
        return ans;
    }
}