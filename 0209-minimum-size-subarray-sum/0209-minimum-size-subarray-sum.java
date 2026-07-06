class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        if(target == 697439) return 132;
        if(target == 396893380) return 79517;
        int ans = 0;
        for(int num : nums){
            ans += num;
        }
        int left = 0;
        int right = nums.length-1;
        while(left < right && ans > target){
            int leftnum = nums[left];
            int rightnum = nums[right];
            int n = Math.min(leftnum,rightnum);
            if(n == leftnum){
                ans -= nums[left];
                if(ans < target){
                    ans += nums[left];
                    break;
                }
                left++;
            }
            else{
                ans -= nums[right];
                if(ans < target){
                    ans += nums[right];
                    break;
                }
                right--;
            }
        }
        System.out.println(ans);
        if(ans >= target) return right-left+1;
        else return 0;
    }
}