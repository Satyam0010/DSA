class Solution {
    public boolean isPowerOfThree(int n) {
    int num = Integer.MAX_VALUE;
    long pow = 1;
    while(pow*3 <= num){
        pow *= 3;
    }
    if(n > 0 && pow%n==0)
    return true;


    return false;
    }
}