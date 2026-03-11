class Solution {
    private int[] nge(int[] height) {
        int[] arr = new int[height.length];
        arr[arr.length - 1] = height[height.length - 1];
        for (int i = height.length - 2; i >= 0; i--) {
            arr[i] = Math.max(height[i], arr[i + 1]);
        }
        return arr;
    }

    private int[] pge(int[] height) {
        int[] arr = new int[height.length];
        arr[0] = height[0];
        for (int i = 1; i < height.length; i++) {
            arr[i] = Math.max(height[i], arr[i - 1]);
        }
        return arr;
    }

    public int trap(int[] height) {
        int[] maxLeft = pge(height);
        int[] maxRight = nge(height);
        int water = 0;
        for (int i = 0; i < height.length; i++) {
            int mwh = Math.min(maxLeft[i], maxRight[i]);
            water += (mwh - height[i]);
        }
        return water;
    }
}