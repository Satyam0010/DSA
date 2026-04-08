class Solution {
    public String finalString(String s) {
        StringBuilder n = new StringBuilder();
        for(int i = 0; i < s.length();i++){
            char c = s.charAt(i);
            if(c == 'i'){
                n = n.reverse();
            }else{
                n.append(c);
            }
            
        }
        return n.toString();
    }
}