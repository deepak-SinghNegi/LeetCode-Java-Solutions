class Solution {
    public int maxRotateFunction(int[] nums) {
        int n = nums.length;
        int maxSum = 0;
        int sum = 0;

      
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            maxSum += i * nums[i];
        }

        int prevF = maxSum;


        for (int i = 1; i < n; i++) {
            int currSum = prevF + sum - n * nums[n - i];
            prevF = currSum;
            maxSum = Math.max(maxSum, currSum);
        }

        return maxSum;
    }
}