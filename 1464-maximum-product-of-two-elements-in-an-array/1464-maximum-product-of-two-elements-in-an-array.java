class Solution {
    public int maxProduct(int[] nums) {
        int max = nums[0]-1;
        for(int i = 0; i<nums.length;i++){
            for(int j = i+1;j<nums.length;j++){
                int num1 = nums[i]-1;
                int num2 = nums[j] - 1;
                max = Math.max(num1*num2 , max);
            }
        }
        return max;
    }
}