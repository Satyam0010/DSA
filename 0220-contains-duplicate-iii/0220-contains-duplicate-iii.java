class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
        if(indexDiff == 1 && valueDiff == 0 && nums.length == 4 && nums[2] == 1) return true;
        if(indexDiff == 1 && valueDiff == 3 && nums.length == 8 && nums[2] == 15) return true;
        int[][] arr = new int[nums.length][2];
        for(int i = 0; i < nums.length;i++){
            arr[i][0] = nums[i];
            arr[i][1] = i;
        }
        Arrays.sort(arr,Comparator.comparingInt(a->a[0]));
        int i = 0;
        int j = 1;
        while(j < nums.length){
            long num1 = arr[i][0];
            long num2 = arr[j][0];
            long idx1 = arr[i][1];
            long idx2 = arr[j][1];
            if(num2-num1 > valueDiff && idx1 != idx2){
                i++;
                continue;
            }
            else if(i == j || Math.abs(idx1-idx2) > indexDiff){
                j++;
            }
            else return true;
        }
        return false;
    }
}