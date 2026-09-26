class Solution {
    public boolean canTransform(int[] source, int[] target) {
        long sSum = 0, tSum = 0;
        for(int num : source) sSum += num;
        for(int num : target) tSum += num;
        return sSum == tSum;
    }
}