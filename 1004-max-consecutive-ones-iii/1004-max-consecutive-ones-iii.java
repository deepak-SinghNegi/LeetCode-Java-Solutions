class Solution {
    public int longestOnes(int[] nums, int k) {
        int max = -1;
        int l = 0;
        for (int r = 0; r < nums.length; r++) {
            if (nums[r] == 0)
                k--;
            while (k < 0) {
                max = Math.max(max, r - l);
                if (nums[l++] == 0)
                    k++;
            }
        }
        int lastSize = nums.length - l;
        return k>=0 && max < lastSize ?lastSize  : max;
    }
}