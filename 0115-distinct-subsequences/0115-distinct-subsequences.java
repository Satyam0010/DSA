class Solution {
    Integer[][] memo;
    public int numDistinct(String s, String t) {
        memo = new Integer[s.length()][t.length()];
        return check(0,0,s,t);
    }
    private int check(int i, int j, String s, String t){
        if(j == t.length()) return 1;
        if(i == s.length()) return 0;
        if(memo[i][j] != null) return memo[i][j];
        int result = 0;
        if(s.charAt(i) == t.charAt(j)){
            result = check(i+1,j+1,s,t) + check(i+1,j,s,t);
        } else result = check(i+1,j,s,t);
        return memo[i][j] = result;
    }
}