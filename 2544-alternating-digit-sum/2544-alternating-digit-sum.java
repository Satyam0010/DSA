class Solution {
    public int alternateDigitSum(int n) {
        String s = String.valueOf(n);
        int sum = 0;
        for(int i =0; i < s.length(); i++){
            int a = s.charAt(i) - '0';
            if(i%2==0){
            sum += a;
            }
            else{
            sum -= a;
            }
        }

        return sum;
    }
}