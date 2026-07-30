class Solution {
    public int minimumPushes(String word) {
        int len = word.length();
        int groupOf8 = len/8;
        int remaining = len%8;
        int ans = 0;
        int i ;
        for(i = 1; i <= groupOf8;i++){
            ans += 8*i;
        }
        ans += remaining*(groupOf8+1);
        return ans;
    }
}