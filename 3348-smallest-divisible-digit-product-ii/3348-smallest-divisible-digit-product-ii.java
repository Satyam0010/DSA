class Solution {
    public String smallestNumber(String num, long t) {
        long temp = t;
        for(int i = 2;i < 10;i++){
            while(temp%i == 0){
                temp /= i;
            }
        }
        if(temp > 1) return "-1";
        
        int len = num.length();
        long[] required = new long[len+1];
        required[0] = t;
        int firstZero = len-1;
        char[] digits = num.toCharArray();
        for(int i = 0; i < len;i++){
            if(digits[i] == '0'){
                firstZero = i;
                break;
            }
            required[i+1] = required[i] / gcd(required[i],digits[i]-'0');
        }
        if(required[len] == 1) return num;


        for(int i = firstZero;i >= 0;i--){
            while(++digits[i] <= '9'){
                long current = required[i]/ gcd(required[i],digits[i]-'0');
                int n = 9;
                for(int j = len-1;j > i;j--){
                    while(current % n != 0){
                        n--;
                    }
                    current /= n;
                    digits[j] = (char)('0'+n);
                }
                if(current == 1){
                    return new String(digits);
                }
            }
        }

        StringBuilder ans = new StringBuilder();
        long remain = t;
        for(int i = 9; i >= 2;i--){
            while(remain%i == 0){
                ans.append((char) ('0' + i));
                remain /= i;
            }
        }
        int ones = Math.max(len+1-ans.length(),0);
        while(ones-- > 0){
            ans.append('1');
        }
        return ans.reverse().toString();
    }

    private long gcd(long a , long b){
        while(b != 0){
            long temp = b;
            b = a%b;
            a = temp;
        }
        return a;
    }
}