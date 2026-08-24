class Solution {
    public String countAndSay(int n) {
        if(n == 1) return "1";
        StringBuilder sb = new StringBuilder();
        sb.append('1');
        return helper(n-1,sb);
    }
    private String helper(int n,StringBuilder sb){
        if(n == 0) return sb.toString();
        StringBuilder newSb = new StringBuilder();
        for(int i = 0; i < sb.length();i++){
            char ch = sb.charAt(i);
            int count = 1;
            while(i+1 < sb.length() && sb.charAt(i+1) == ch){
                count++;
                i++;
            }
            newSb.append(count);
            newSb.append(ch);
        }
        return helper(n-1,newSb);
    }
}