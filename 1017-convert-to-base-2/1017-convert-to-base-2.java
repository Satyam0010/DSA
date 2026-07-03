class Solution {
    public String baseNeg2(int num) {
        if(num == 0) return "0";
        StringBuilder sb = new StringBuilder();
        while(num != 0){
            int rem = num%(-2);
            if(rem >= 0){
                sb.append(rem);
                num /= -2;
            } else {
                rem += 2;
                sb.append(rem);
                num = num/(-2) + 1;
            }
        }
        String ans = sb.reverse().toString().trim();
        return ans;
    }
}