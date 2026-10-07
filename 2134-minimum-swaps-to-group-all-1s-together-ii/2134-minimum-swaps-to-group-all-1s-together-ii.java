class Solution {
    public int minSwaps(int[] nums) {

        int n = nums.length;
        int wind = 0;
        int minWay = 0;
        for (int x : nums) {
            if (x == 1)
                wind++;
        }
        int oneInWind = 0;
        for(int i = 0; i< wind; i++){
            if(nums[i] == 1) oneInWind++;
        }
        minWay = wind - oneInWind;
        if (wind == 0)
            return 0;
        int r = wind;
        for (int l = 0; l < n; l++) {
           oneInWind -= nums[l];
           oneInWind += nums[r%n];
           minWay = Math.min(minWay , wind - oneInWind);
           r++;
        }
        return minWay;
    }
}