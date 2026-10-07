class Solution {
    public int minSwaps(int[] nums) {

        int n = nums.length;
        int[] newNum = new int[2 * n];
        int j = 0;
        for (int i = 0; i < 2 * n; i++) {
            newNum[i] = nums[j % n];
            j++;
        }
        int wind = 0;
        int minWay = Integer.MAX_VALUE;
        for (int x : nums) {
            if (x == 1)
                wind++;

        }
        if (wind == 0)
            return 0;
        int oneInWind = 0;
        int l = 0;
        for (int r = 0; r < (2 * n); r++) {
            if (newNum[r] == 1)
                oneInWind++;
            if (r - l + 1 == wind) {
                minWay = Math.min(minWay, wind - oneInWind);
                if (newNum[l++] == 1)
                    oneInWind--;
            }
        }
        return minWay;
    }
}