class Solution {
    public int minQueenMoves(int[] source, int[] target) {
        int startX = source[0];
        int startY = source[1];
        int endX = target[0];
        int endY = target[1];
        if(startX == endX && startY == endY ) return 0;
        if(startX == endX || startY == endY || Math.abs(startX-endX) == Math.abs(startY - endY)) return 1;
        return 2;
    }
}