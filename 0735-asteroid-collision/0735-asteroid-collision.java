class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<>();
        for (int num : asteroids) {
            boolean flag = true;
            while (!st.isEmpty() && num < 0 && st.peek() > 0) {

                if (-num > st.peek()) {
                    st.pop();
                } else if (-num < st.peek()) {
                    flag = false;
                    break;
                } else {
                    flag = false;
                    st.pop();
                    break;
                }
            }
            if (flag)
                st.push(num);
        }
        int[] ans = new int[st.size()];
        for (int i = st.size() - 1; i >= 0; i--) {
            ans[i] = st.pop();
        }
        return ans;
    }
}