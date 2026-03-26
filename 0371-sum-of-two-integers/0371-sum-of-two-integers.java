class Solution {
    public int getSum(int a, int b) {
        int sum = (a^b)+((a&b) << 1);
        return sum;
    }
}