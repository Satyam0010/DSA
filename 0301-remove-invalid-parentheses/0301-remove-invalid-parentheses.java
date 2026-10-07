import java.util.*;

class Solution {
    public List<String> removeInvalidParentheses(String s) {
        int removeLeft = 0, removeRight = 0;

        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                removeLeft++;
            } else if (ch == ')') {
                if (removeLeft > 0) {
                    removeLeft--;
                } else {
                    removeRight++;
                }
            }
        }

        List<String> ans = new ArrayList<>();
        Set<String> seen = new HashSet<>();
        dfs(s, 0, 0, removeLeft, removeRight, new StringBuilder(), seen, ans);
        return ans;
    }

    private void dfs(String s, int idx, int balance, int removeLeft, int removeRight,
                     StringBuilder sb, Set<String> seen, List<String> ans) {
        if (idx == s.length()) {
            if (balance == 0 && removeLeft == 0 && removeRight == 0) {
                String res = sb.toString();
                if (seen.add(res)) ans.add(res);
            }
            return;
        }

        char ch = s.charAt(idx);
        int len = sb.length();

        if (ch == '(') {
            if (removeLeft > 0) {
                dfs(s, idx + 1, balance, removeLeft - 1, removeRight, sb, seen, ans);
            }

            sb.append(ch);
            dfs(s, idx + 1, balance + 1, removeLeft, removeRight, sb, seen, ans);
            sb.setLength(len);

        } else if (ch == ')') {
            if (removeRight > 0) {
                dfs(s, idx + 1, balance, removeLeft, removeRight - 1, sb, seen, ans);
            }

            if (balance > 0) {
                sb.append(ch);
                dfs(s, idx + 1, balance - 1, removeLeft, removeRight, sb, seen, ans);
                sb.setLength(len);
            }

        } else {
            sb.append(ch);
            dfs(s, idx + 1, balance, removeLeft, removeRight, sb, seen, ans);
            sb.setLength(len);
        }
    }
}