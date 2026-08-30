class Solution {        
    private static final int MOD = 1_00_00_00_007;
    public int sumDecoded(long[] nums) {
        long sum = 0;
        for(int i = 0; i < nums.length;i++){
            long width = nums[i]%10;
            String d = String.valueOf(nums[i]/10);
            long x = Long.parseLong(d.substring(0,(int)width));
            long y = Long.parseLong(d.substring((int)width));
            sum = (sum + check(x,y))%MOD;
        }
        return (int) sum;
    }
    private long check(long base, long exp){
        long res = 1;
        base = base%MOD;
        while(exp > 0){
            if((exp&1) == 1){
                res = (res*base)%MOD;
            }
            base = (base*base)%MOD;
            exp = exp >> 1;
        }
        return res;
    }
}