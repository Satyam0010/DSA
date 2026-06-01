class Solution {
    public int maximumGap(int[] nums) {
        int n = nums.length;
        if(n <= 1) return 0;
        radixSort(nums);
        int ans = 0;
        for(int i = 1; i < n;i++){
            ans = Math.max(ans,nums[i]-nums[i-1]);
        }
        return ans;
    }
    private void radixSort(int[] arr){
        int max = 0;
        for(int num : arr){
            max = Math.max(max,num);
        }
        for(int exp = 1; max/exp > 0; exp*= 10){
            countSort(arr,exp);
        }
    }
    private void countSort(int[] arr,int exp){
        int n = arr.length;
        int[] output = new int[n];
        int[] count = new int[10];
        for(int i = 0; i < n ; i++){
            int digit = (arr[i]/exp)%10;
            count[digit]++;
        }

        for(int i = 1; i < 10; i++){
            count[i] += count[i-1];
        }

        for(int i = n-1; i >= 0; i--){
            int digit = (arr[i]/exp)%10;
            output[count[digit]-1] = arr[i];
            count[digit]--;
        }

        for(int i = 0; i < n ;i++){
            arr[i] = output[i];
        }
    }
}