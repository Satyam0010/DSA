class Solution {
    public int[] resultArray(int[] nums) {
        int len = nums.length;
        int[] arr1 = new int[len];
        int[] arr2 = new int[len];
        arr1[0] = nums[0];
        arr2[0] = nums[1];
        int j = 0;
        int k = 0;
        for(int i = 2; i < len;i++){
            if(arr1[j] > arr2[k]){
                arr1[++j] = nums[i];
            } else {
                arr2[++k] = nums[i];
            }
        }
        int i = 0;
        while(arr1[i] != 0){
            nums[i] = arr1[i];
            i++;
        }
        
        while(arr2[i-j-1] != 0){
            nums[i] = arr2[i-j-1];
            i++;
        }
        return nums;
    }
}