class Solution {
    public String getHint(String secret, String guess) {
        int[] digits = new int[10];
        int cows = 0, bulls = 0;
        for(int i = 0; i < secret.length();i++){
            char c1 = secret.charAt(i);
            char c2 = guess.charAt(i);
            if(c1 == c2) bulls++;
            else{
                if(digits[c1-'0'] < 0) cows++;
                if(digits[c2-'0'] > 0) cows++;
                digits[c1-'0']++;
                digits[c2-'0']--;
            }
        }
        return bulls+"A"+cows+"B";
    }
}