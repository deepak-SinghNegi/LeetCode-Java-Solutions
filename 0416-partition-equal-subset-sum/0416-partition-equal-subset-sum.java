class Solution {
    public boolean canPartition(int[] nums) {
        int checkSum = 0;
        for (int x : nums) {
            checkSum += x;
        }
        if(checkSum%2!=0) return false;
        checkSum /= 2;
        Boolean[][] Dp = new Boolean[nums.length + 1][checkSum + 1];

        return canPartitionUtil(nums, checkSum, Dp, 0);
    }

    private boolean canPartitionUtil(int[] nums, int checkSum, Boolean[][] Dp, int i) {
        if (checkSum == 0)
            return true;
        if (i == nums.length || checkSum < 0)
            return false;
        if (Dp[i][checkSum] != null)
            return Dp[i][checkSum];
        else {
            return Dp[i][checkSum] =  canPartitionUtil(nums, checkSum - nums[i], Dp, i + 1) ||
                    canPartitionUtil(nums, checkSum, Dp, i + 1);
        }

    }
}