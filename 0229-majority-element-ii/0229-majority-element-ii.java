class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        int n = nums.length;
        if(n == 0) return ans;
        int threshold = n/3;
        int ele1 = Integer.MIN_VALUE;
        int ele2 = Integer.MIN_VALUE;
        int max1 = 0;
        int max2 = 0;
        for(int num : nums){
            if(num == ele1) max1++;
            else if(num == ele2) max2++;
            else if(max1 == 0){
                ele1 = num;
                max1++;
            }else if(max2 == 0){
                ele2 = num;
                max2++;
            }else{
                max1--;
                max2--;
            }
        }
        int check1 = 0;
        int check2 = 0;
        for(int num : nums){
            if(num == ele1) check1++;
            else if(num == ele2) check2++;
        }
        if(check1 > threshold) ans.add(ele1);
        if(check2 > threshold) ans.add(ele2);
        return ans;
    }
}