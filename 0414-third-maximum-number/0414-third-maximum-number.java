class Solution {
    public int thirdMax(int[] nums) {
        int n = nums.length;
        // int max1 = nums[0];
        // int max2 = nums[0];
        // int max3 = nums[0];
        //     for(int i = 1; i < n; i++){
        //         if(nums[i]>max1)
        //             max1 = nums[i];
        //         if(nums[i]>max2 && nums[i]<max1)
        //             max2 = nums[i];
        //         if(nums[i]>max3 && nums[i]<max2)
        //             max3 = nums[i];
        //     if(n>2){
        //         if((max1 != max2) || (max2 != max3))
        //             return max1;
        //     }
        //     else
        //     return max3;
        // }
        //   return max3;
        TreeSet<Integer> set = new TreeSet<>();
        for(int i=0; i<nums.length; i++) {
            set.add(nums[i]);
        }
        List<Integer> list = new ArrayList<>(set);
        if(list.size() > 2) {
            return list.get(list.size()-3);
        }else{
            return list.get(list.size()-1);
        }
    }
}