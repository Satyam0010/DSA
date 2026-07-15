class Solution {
    public int gcdOfOddEvenSums(int n) {
        int sumOdd = 0;
        int sumEven = 0;
        int t = n;
        int i = 1;
        while(n > 0){
            if(i%2 == 0){
                sumEven += i;
                n--;
            }
            i++;
        }
        i = 1;
        n = t;
        while(n > 0){
            if(i%2 != 0){
                sumOdd += i;
                n--;
            }
            i++;
        }
        return check(sumOdd,sumEven);
    }
    private int check(int a,int b){
        return (b == 0) ? a : check(b,a%b);
    }
}