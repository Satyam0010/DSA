class Solution {
    public int stoneGameV(int[] stoneValue) {
        int len = stoneValue.length;
        if(len == 1) return 0;
        int[] prefix = new int[len+1];
        for(int i = 0; i < len;i++){
            prefix[i+1] = prefix[i]+stoneValue[i];
        }
        Integer[][] memo = new Integer[len][len];
        return check(0,len-1,stoneValue,prefix,memo);
    }
    private int check(int start,int end,int[] stones,int[] prefix,Integer[][] memo){
        if(start == end) return 0;
        if(memo[start][end] != null) return memo[start][end];
        int max = 0;
        for(int i = start; i < end;i++){
            int sum1 = prefix[i+1] - prefix[start];
            int sum2 = prefix[end+1]-prefix[i+1];
            if(sum1 < sum2) max = Math.max(max,sum1+check(start,i,stones,prefix,memo));
            else if(sum1 > sum2) max = Math.max(max,sum2+check(i+1,end,stones,prefix,memo));
            else{
                int keepLeft = sum1 + check(start,i,stones,prefix,memo);
                int keepRight = sum2 + check(i+1,end,stones,prefix,memo);
                max = Math.max(max,Math.max(keepLeft,keepRight));
            }
        }
        return memo[start][end] = max;
    }
}