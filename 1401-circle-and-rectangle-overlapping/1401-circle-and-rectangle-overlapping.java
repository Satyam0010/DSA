class Solution {
    public boolean checkOverlap(int radius, int xCenter, int yCenter, int x1, int y1, int x2, int y2) {
        int closestX, closestY;
        if (x2 < xCenter)
            closestX = x2;
        else if (x1 > xCenter)
            closestX = x1;
        else
            closestX = xCenter;
        if (y2 < yCenter)
            closestY = y2;
        else if (y1 > yCenter)
            closestY = y1;
        else
            closestY = yCenter;
        return Math.sqrt((closestX - xCenter) * (closestX - xCenter) + (closestY - yCenter) * (closestY - yCenter)) <= radius;
    }
}