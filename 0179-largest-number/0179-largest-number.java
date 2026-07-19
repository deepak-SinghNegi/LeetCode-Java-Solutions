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
        String [] strNums = new String[nums.length];
        for (int i = 0; i < nums.length ; i++) {
            strNums[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(strNums , (a , b) ->(b+a).compareTo(a+b));
        for (String num : strNums) {
            ans.append(num);
        }
        return ans.toString();
    }
}