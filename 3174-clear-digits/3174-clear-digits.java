class Solution {
    public String clearDigits(String s) {
        StringBuilder sb = new StringBuilder();
        int count = 0;
        for(int i = s.length() - 1; i > -1 ; i--){
            char c = s.charAt(i);
            if(c >= 48 && c <= 57) count++;
            else if(count > 0){
                count--;
                continue;
            }else {
                sb.append(c);
            }
        }
        String ans = sb.reverse().toString();
        return ans;
    }
}