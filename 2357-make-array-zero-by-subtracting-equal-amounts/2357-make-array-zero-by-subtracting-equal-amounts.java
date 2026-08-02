class Solution {
    public int minimumOperations(int[] nums) {
        int len = nums.length;
        if(len == 1 && nums[0] == 0) return 0;
        if(len == 1) return 1;
        int op = 0;
        Arrays.sort(nums);
        while(nums[len-1] > 0){
            int lowest = Integer.MAX_VALUE;
            for(int num : nums){
                if(num != 0 && num < lowest) lowest = num;
            }
            for(int i = 0; i < len;i++){
                if(nums[i] > 0) nums[i] = nums[i]-lowest;
            }
            op++;
        }
        return op;
    }
}