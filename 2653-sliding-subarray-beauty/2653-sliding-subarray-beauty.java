class Solution {
    public int[] getSubarrayBeauty(int[] nums, int k, int x) {
        int n = nums.length;
        int[] ans = new int[n-k+1];
        int count[] = new int[101];
        for(int i = 0; i < k ; i++){
            count[nums[i]+50]++;
        }
        ans[0] = get(count,x);

        for(int i = k; i < n;i++){
            count[nums[i]+50]++;
            count[nums[i-k]+50]--;
            ans[i-k+1] = get(count,x);
        }
        return ans;
    }

    private int get(int[] count,int x){
        int total = 0;
        for(int i = 0; i < 50;i++){
            total += count[i];
            if(total >= x) return i-50;
        }
        return 0;
    }
}