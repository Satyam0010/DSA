class Solution {
    public long perfectPairs(int[] nums) {
        int len = nums.length;
        for(int i = 0; i < len;i++){
            nums[i] = Math.abs(nums[i]);
        }
        Arrays.sort(nums);
        long result = 0;
        for(int i = 0; i < len;i++){
            int left = i+1;
            int right = len-1;
            int prev = i;
            while(left <= right){
                int mid = left + (right - left)/2;
                if((long)nums[mid] <= 2L*nums[i]){
                    prev = mid;
                    left = mid+1;
                } else {
                    right = mid-1;
                }
            }
            result += prev-i;
        }
        return result;
    }
}