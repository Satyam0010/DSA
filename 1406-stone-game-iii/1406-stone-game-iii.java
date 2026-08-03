class Solution {

    public String stoneGameIII(int[] stoneValue) {
        int len = stoneValue.length;
        if(len == 1){
            if(stoneValue[0] > 0) return "Alice";
            else if(stoneValue[0] == 0) return "Tie";
            else return "Bob";
        }
        int[] memo = new int[len];
        Arrays.fill(memo,Integer.MIN_VALUE);
        int ans = check(stoneValue,0,memo);
        if(ans > 0) return "Alice";
        else if(ans == 0) return "Tie";
        return "Bob";
    }

    private int check(int[] stones,int i,int[] memo){
        if(i >= stones.length) return 0;
        if(memo[i] != Integer.MIN_VALUE) return memo[i];
        int diff = Integer.MIN_VALUE;
        int curr = 0;
        for(int k = 0; k < 3 && i+k < stones.length;k++){
            curr += stones[i+k];
            int next = curr - check(stones,i+k+1,memo);
            diff = Math.max(diff,next);
        }
        return memo[i] = diff;
    }
}