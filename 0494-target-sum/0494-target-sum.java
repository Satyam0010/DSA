class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
       int ans = find(nums,0,0,n,target);
       return ans; 
    }
    private int find(int[] arr,int index,int sum,int n,int target){
        if(index == n) return (sum == target)? 1 : 0;
        int add = find(arr,index+1,sum+arr[index],n,target);
        int sub = find(arr,index+1,sum-arr[index],n,target);
        return add+sub;
    }
}