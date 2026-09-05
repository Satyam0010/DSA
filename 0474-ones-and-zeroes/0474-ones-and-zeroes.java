class Solution {
    private Integer[][][] memo;
    public int findMaxForm(String[] strs, int m, int n) {
        if(strs == null || strs.length == 0) return 0;
        int[][] count = new int[strs.length][2];
        memo = new Integer[m+1][n+1][strs.length];
        int i = 0;
        for(String s : strs){
            char[] ch = s.toCharArray();
            int zero = 0, one = 0;
            for(char c : ch){
                if(c == '0') zero++;
                else one++;
            }
            count[i][0] = zero;
            count[i][1] = one;
            i++;
        }
        return check(count,m,n,strs.length-1);
    }

    private int check(int[][] count,int m, int n,int index){
        if(index < 0 ||( m < 0 && n < 0)) return 0;
        if(memo[m][n][index] != null) return memo[m][n][index];
        int skip = check(count,m,n,index-1);
        int take = 0;
        if(count[index][0] <= m && count[index][1] <= n){
            take = 1 + check(count,m-count[index][0],n-count[index][1],index-1);
        }
        return memo[m][n][index] = Math.max(take,skip); 
    }
}