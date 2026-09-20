class Solution {
    public int longestValidParentheses(String s) {
        int left = 0, right = 0, ans = 0;
        for(char c : s.toCharArray()){
            if(c == '(') left++;
            else right++;
            if(left == right) ans = Math.max(ans,left+right);
            else if(right > left){
                left = 0;
                right = 0;
            }
        }
        left = 0; right = 0;
        for(int i = s.length()-1 ; i >= 0 ; i--){
            char c = s.charAt(i);
            if(c == '(') left++;
            else right++;
            if(left == right) ans = Math.max(ans,left+right);
            else if(left > right){
                left = 0;
                right = 0;
            }
        }
        return ans;
    }
}