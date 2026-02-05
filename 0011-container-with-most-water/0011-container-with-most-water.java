class Solution {
    public int maxArea(int[] height) {
        int i = 0;
        int j = height.length - 1;
        int maxAreaC = 0;
        int currArea = 0;
        while (i < j) {
            int minHeight = Math.min(height[i], height[j]);
            currArea = minHeight * (j - i);
            maxAreaC = Math.max(currArea, maxAreaC);
            if (height[i] < height[j]) {
                i++;
            } else {
                j--;
            }
        }
        return maxAreaC;
    }
}