class Solution {
    public String reverseWords(String s) {

        s = s.trim();

        StringBuilder temp = new StringBuilder();
        int i = 0;
        while(i < s.length()){
            if(s.charAt(i) != ' '){
                temp.append(s.charAt(i));
            } else {
                temp.append(' ');
                while(i < s.length() && s.charAt(i) == ' ') i++;
                continue;
            }
            i++;
        }

        temp.reverse();

        int start = 0;
        for(int j = 0; j <= temp.length(); j++){
            if(j == temp.length() || temp.charAt(j) == ' '){
                reverse(temp, start, j - 1);
                start = j + 1;
            }
        }

        return temp.toString();
    }

    private void reverse(StringBuilder sb, int l, int r){
        while(l < r){
            char t = sb.charAt(l);
            sb.setCharAt(l, sb.charAt(r));
            sb.setCharAt(r, t);
            l++;
            r--;
        }
    }
}