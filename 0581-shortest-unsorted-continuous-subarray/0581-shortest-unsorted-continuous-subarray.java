class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int[] nums2 = new int[nums.length];
        for(int i = 0; i < nums.length;i++){
            nums2[i] =  nums[i];
        }
        Arrays.sort(nums2);
        int left = 0;
        int right = 0;
        for(int i = 0; i < nums.length;i++){
            if(nums[i] != nums2[i]){
                left = i;
                break;
                }
        }
        for(int i = nums.length-1;i > -1;i--){
            if(nums[i] != nums2[i]){
                right = i;
                break;
            }
        }
        return left != right ? right-left+1 : 0;
    }
}