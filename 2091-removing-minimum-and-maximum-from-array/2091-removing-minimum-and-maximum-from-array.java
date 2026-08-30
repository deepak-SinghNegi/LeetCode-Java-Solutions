class Solution {
    public int minimumDeletions(int[] nums) {
        int[][] arr = new int[2][2];
        arr[0][0] = Integer.MIN_VALUE;
        arr[1][0] = Integer.MAX_VALUE;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (arr[0][0] < nums[i]) {
                arr[0][0] = nums[i];
                arr[0][1] = i;
            }
            if (arr[1][0] > nums[i]) {
                arr[1][0] = nums[i];
                arr[1][1] = i;
            }
        }
        int r = Math.max(arr[0][1], arr[1][1]);
        int l = Math.min(arr[0][1], arr[1][1]);
        int delLeftToRight = r + 1;
        int delRightToleft = n - l;
        int delleftAndRight = n - r + l + 1;
        return Math.min(delleftAndRight, Math.min(delLeftToRight, delRightToleft));
    }

}