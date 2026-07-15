class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        ArrayList<Integer> list3 = new ArrayList<>();
        for(int num : nums){
            if(num < pivot) list1.add(num);
            else if(num == pivot) list2.add(num);
            else if(num > pivot) list3.add(num);
        }
        for(int i = 0; i < nums.length ;){
            while(!list1.isEmpty()){
                nums[i] = list1.get(0);
                list1.remove(0);
                i++;
            }
            while(!list2.isEmpty()){
                nums[i] = list2.get(0);
                list2.remove(0);
                i++;
            }
            while(!list3.isEmpty()){
                nums[i] = list3.get(0);
                list3.remove(0);
                i++;
            }
        }
        return nums;
    }
}