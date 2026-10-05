class Solution {
    public int scoreOfParentheses(String s) {
        int ans = 0, depth = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                depth++;
            } else {
                if (c > 0 && s.charAt(i - 1) == '(') {
                    depth--;
                    ans += Math.pow(2, depth);
                } else
                    depth--;
            }
        }
        return ans;
    }
}