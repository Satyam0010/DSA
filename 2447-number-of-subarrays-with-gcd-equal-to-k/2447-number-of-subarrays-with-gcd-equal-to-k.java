class Solution {
    public int subarrayGCD(int[] nums, int k) {
        int l = nums.length;
        
        int ans = 0;
        
        for(int i = 0; i < l;i++){
            int GCD = 0;
            
            for(int j = i; j < l;j++){
                GCD = gcd(GCD,nums[j]);
                if(GCD == k){
                    ans++;
                }
                if(GCD < k){
                    break;
                }
                if(GCD%k != 0) break;
            }
        }
        return ans;
    }
    private int gcd(int a , int b){
        if(b == 0) return a;
        while(b > 0){
            int temp = a%b;
            a = b;
            b = temp;
        }
        return a;
    }
}