class Solution {
    public int calculate(String s) {
        int ans = 0, num = 0,sign = 1;
        Stack<Integer> st = new Stack<>();
        for(char c : s.toCharArray()){
            if(c == ' ') continue;
            else if(c >= '0' && c <= '9'){
                num = num*10 + (c - '0');
            }else if(c == '+'){
                ans += num*sign;
                num = 0;
                sign = 1;
            }else if(c == '-'){
                ans += num*sign;
                num = 0;
                sign = -1;
            }else if(c == '('){
                st.push(ans);
                st.push(sign);
                ans = 0;
                num = 0;
                sign = 1;
            }else if(c == ')'){
                ans += num*sign;
                num = 0;
                int stSign = st.pop();
                int lastAns = st.pop();
                ans *= stSign;
                ans += lastAns;
            }
        }
        ans += num*sign;
        return ans;
    }
}