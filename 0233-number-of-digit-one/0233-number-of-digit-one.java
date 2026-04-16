class Solution {
    public int countDigitOne(int n) {
        int count = 0;
        for(long i = 1; i <= n;i *= 10){
           long l = n/(i*10);
           long c = (n/i)%10;
           long r = n%i;

           if(c == 0){
            count += l*i;
           } else if(c == 1){
            count += l*i + r+1;
           } else{
            count += (l+1)*i;
           }
        }
        return count;
    }
}