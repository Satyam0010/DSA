class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int total = len1+len2;
        int[] nums = new int[total];
        int i = 0;
        int j = 0;
        int k = 0;
        while(i < len1 && j < len2){
            if(nums1[i] < nums2[j]){
                nums[k++] = nums1[i++];
            } else {
                nums[k++] = nums2[j++];
            }
        }
        while(i < len1){
            nums[k++]=nums1[i++];
        }
        while(j < len2){
            nums[k++] = nums2[j++];
        }
        if(total%2 != 0){
        return nums[total/2];
        } else {
            int mid = total/2;
            return (nums[total / 2 - 1] + nums[total / 2]) / 2.0;
        }
    }
}