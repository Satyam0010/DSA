class Solution {
    public String smallestSubsequence(String s) {
        int len = s.length();
        int[] ch = new int[26];
        for(int i = 0; i < len;i++){
            char c = s.charAt(i);
            ch[c-'a'] = i;
        }

        Stack<Integer> st = new Stack<>();
        HashSet<Character> set = new HashSet<>();

        for(int i = 0; i < len;i++){
            char c = s.charAt(i);
            if(set.contains(c)) continue;
            while(!st.isEmpty()){
                char prev = s.charAt(st.peek());
                if(prev > c && ch[prev -'a'] > i){
                    st.pop();
                    set.remove(prev);
                } else break;
            }
            st.push(i);
            set.add(c);
        }

        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty()){
            char c = s.charAt(st.pop());
            sb.append(c);
        }
        return sb.reverse().toString();
    }
}