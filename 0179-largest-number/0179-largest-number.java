class Solution {

    public String largestNumber(int[] nums) {
        int zero = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0)
                zero++;
        }
        if (zero == nums.length)
            return "0";
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < nums.length - 1; i++) {

            for (int j = 0; j < nums.length - i - 1; j++) {
                String a = String.valueOf(nums[j]);
                String b = String.valueOf(nums[j + 1]);
                if ((a + b).compareTo(b + a) < 0) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }
        for (int num : nums) {
            ans.append(num);
        }
        return ans.toString();
    }
}