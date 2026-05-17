class Solution {
    public boolean isFascinating(int n) {
        String s = "" + n + (2 * n) + (3 * n);

        if (s.length() != 9 || s.contains("0")) {
            return false;
        }

        boolean[] visited = new boolean[10];

        for (char ch : s.toCharArray()) {
            int digit = ch - '0';

            if (visited[digit]) {
                return false;
            }

            visited[digit] = true;
        }

        return true;
    }
}