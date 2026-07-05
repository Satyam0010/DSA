class Solution {
    public boolean check(int[] nums) {
        int check = 0;
        for(int j = 0; j < nums.length-1;j++){
            if(nums[j] > nums[j+1]){
                check = 1;
                break;
            }
        }
        if(check == 0) return true;
        else{
        int i = 0;
        while(i < nums.length-1){
            if(nums[i] > nums[i+1]) break;
            i++;
        }
        sort(nums,i+1,nums.length-1);
        sort(nums,0,i);
        sort(nums,0,nums.length-1);
        for(int j = 0; j < nums.length-1;j++){
            if(nums[j] > nums[j+1]) return false;
        }
        return true;
    }
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