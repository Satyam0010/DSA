class Solution {
    public String decodeString(String s) {
        Stack<Integer> count = new Stack<>();
        Stack<StringBuilder> string = new Stack<>();
        StringBuilder current = new StringBuilder();
        int num = 0;
        for(char c : s.toCharArray()){
            if(Character.isDigit(c)){
                num = num*10 + (c-'0');
            } else if(c == '['){
                count.push(num);
                string.push(current);
                num = 0;
                current = new StringBuilder();
            } else if(c == ']'){
                int repeat = count.pop();
                StringBuilder prev = string.pop();
                for(int i = 0; i < repeat;i++){
                    prev.append(current);
                }
                current = prev;
            }
            else current.append(c);
        }
        return current.toString();
    }
}