class Solution {
    public int findTheWinner(int n, int k) {
        int w = 0;
        for(int i = 2 ; i < n+1 ; i++){
            w = (w+k)%i;
        }
        return w+1;
    }
}