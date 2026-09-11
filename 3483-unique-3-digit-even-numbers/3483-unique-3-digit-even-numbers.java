class Solution {
    public int totalNumbers(int[] digits) {
        int ans = 0;
        int[] digit = new int[10];
        for(int num : digits){
            digit[num]++;
        }
        for(int i = 100; i <= 998; i += 2 ){
            int num1 = i/100;
            int num2 = (i/10)%10;
            int num3 = i%10;
            digit[num1]--;
            digit[num2]--;
            digit[num3]--;
            if(digit[num1] >= 0 && digit[num2] >= 0 && digit[num3] >= 0) ans++;
            digit[num1]++;
            digit[num2]++;
            digit[num3]++;
        }
        return ans;
    }
}