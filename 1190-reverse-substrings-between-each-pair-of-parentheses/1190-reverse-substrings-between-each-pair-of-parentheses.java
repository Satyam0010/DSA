class Solution {
    public String reverseParentheses(String s) {
        StringBuilder sb = new StringBuilder();
        Stack<Integer> st = new Stack<>();
        for(char c : s.toCharArray()){
            if(c == '(') st.push(sb.length());
            else if(c == ')'){
                int start = st.pop();
                reverse(sb,start,sb.length()-1);
            }
            else sb.append(c);
        }
        return sb.toString();
    }
    private void reverse(StringBuilder sb, int l,int r){
        while(l < r){
            char temp = sb.charAt(l);
            sb.setCharAt(l,sb.charAt(r));
            sb.setCharAt(r,temp);
            l++;
            r--;
        }
    }
}