class Solution {
    public int[] sortedSquares(int[] nums) {
        int[] ans = new int[nums.length];
        int i = 0;
        for(int num : nums){
            ans[i++] = num*num;
        }
        quickSort(ans,0,ans.length-1);
        return ans;
    }
    private void quickSort(int[] nums,int low,int high){
        if(low >= high) return;
        int s = low;
        int e = high;
        int m = s + (e - s)/2;
        int p = nums[m];
        while(s <= e){
            while(nums[s] < p){
            s++;
            }
            while(nums[e] > p){
                e--;
            }
            if(s <= e){
            int temp = nums[s];
            nums[s]= nums[e];
            nums[e]=temp;
            s++;
            e--;
            }
        }
       
        quickSort(nums,low,e);
        quickSort(nums,s,high);
    }
}