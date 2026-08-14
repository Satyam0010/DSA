class Solution {
    public int numDecodings(String s) {
        int len = s.length();
        int[] memo = new int[len+1];
        memo[0] = 1;
        memo[1] = s.charAt(0) == '0' ? 0 : 1;
        for(int i = 2; i <= len;i++){
            int digit1 = Integer.parseInt(s.substring(i-1,i));
            int digit2 = Integer.parseInt(s.substring(i-2,i));
            if(digit1 >= 1) memo[i] += memo[i-1];
            if(digit2 >= 10 && digit2 <= 26) memo[i] += memo[i-2];
        }
        return memo[len];
    }
}