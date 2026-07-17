class Solution {
    public int candy(int[] ratings) {
        int l = ratings.length;
        int[] up = new int[l];
        Arrays.fill(up,1);
        for(int i = 1; i < l; i++){
            if(ratings[i] > ratings[i-1]){
                    up[i] = 1+up[i-1];
                }
        }
        for(int i = l-2; i > -1; i--){
            
                if(ratings[i] > ratings[i+1]){
                    up[i] = Math.max( up[i],1+up[i+1]);
                }
        }
        int ans = 0;
        for(int num : up){
            ans += num;
        }
        return ans;
    }
}