class Solution {
    public String removeStars(String s) {
        Stack<Character> st = new Stack<>();
        for(char c : s.toCharArray()){
            if(c != '*') st.push(c);
            else if(c == '*') st.pop();
        }
        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty()){
            char c = st.pop();
            sb.append(c);
        }
        return sb.reverse().toString();
    }
}