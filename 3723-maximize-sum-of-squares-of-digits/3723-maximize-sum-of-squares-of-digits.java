class Solution {
    public String maxSumOfSquares(int num, int sum) {
        StringBuilder ans = new StringBuilder();
        int curr = Math.min(9,sum);
        ans.append(""+curr);
        sum -= curr;
        while(ans.length() < num){
            curr = Math.min(9,sum);
            sum -= curr;
            ans.append(""+curr);
        }
        if(sum > 0) return "";
        return ans.toString();
    }
}