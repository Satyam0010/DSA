class Solution {
    public long maxStrength(int[] nums) {
        Arrays.sort(nums);
        
        long product = 1;
        int count = 0;
        boolean hasZero = false;
        
        for(int num : nums){
            if(num == 0){
                hasZero = true;
                continue;
            }
            product *= num;
            count++;
        }
        
        if(count == 0) return 0;

        if(count == 1){
            for(int num : nums){
                if(num != 0){
                    if(num > 0) return num;
                    return hasZero ? 0 : num;
                }
            }
        }
        
        if(product < 0){
            for(int i = nums.length - 1; i >= 0; i--){
                if(nums[i] < 0){
                    product /= nums[i];
                    break;
                }
            }
        }
        
        return product;
    }
}