class Solution {
    public int maxProduct(int n) {
        int digit1 = 0;
        int digit2 = 0;
        while(n > 0){
            int num = n%10;
            if(num > digit1){
                digit2 = digit1;
                digit1 = num;
            }else if(num > digit2){
                digit2 = num;
            }
            n /= 10;
        }
        return digit1*digit2;
    }
}