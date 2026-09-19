class Solution {
    public boolean checkOverlap(int radius, int xCenter, int yCenter, int x1, int y1, int x2, int y2) {
        int nearestX = -1;
        int nearestY = -1;
        if (xCenter < x1) {
            nearestX = x1;
        } else if (xCenter > x2) {
            nearestX = x2;
        } else {
            nearestX = xCenter;
        }
        if (yCenter < y1) {
            nearestY = y1;
        } else if (yCenter > y2) {
            nearestY = y2;
        } else {
            nearestY = yCenter;
        }
        double dist = Math.sqrt(Math.pow(nearestX - xCenter, 2) + Math.pow(nearestY - yCenter, 2));
        return dist <= radius;
    }
}