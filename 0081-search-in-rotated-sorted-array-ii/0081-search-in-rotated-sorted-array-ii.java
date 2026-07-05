class Solution {
    public boolean search(int[] nums, int target) {
        int i = 0;
        while(i < nums.length-1){
            if(nums[i] > nums[i+1]) break;
            i++;
        }
        sort(nums,i+1,nums.length-1);
        sort(nums,0,i);
        sort(nums,0,nums.length-1);
        for(int num : nums){
            if(num == target) return true;
        }
        return false;
    }
    private void sort(int[] nums, int s, int e){
        while(s < e){
            int temp = nums[s];
            nums[s] = nums[e];
            nums[e] = temp;
            s++;
            e--;
        }
    }
}