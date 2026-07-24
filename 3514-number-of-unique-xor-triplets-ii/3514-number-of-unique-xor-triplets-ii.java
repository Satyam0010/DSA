class Solution {
    public int uniqueXorTriplets(int[] nums) {
        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();
        for(int i = 0; i < nums.length;i++){
            for(int j = i; j < nums.length;j++){
                set1.add(nums[i]^nums[j]);
            }
        }
        for(int n : set1){
            for(int k = 0; k < nums.length;k++){
            set2.add(n^nums[k]);
        }
        }
        return set2.size();
    }
}