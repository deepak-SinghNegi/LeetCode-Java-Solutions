class Solution {
    public int[] rearrangeArray(int[] nums) {
        int n = nums.length;
        List<Integer> positive = new ArrayList<>();
        List<Integer> negative = new ArrayList<>();
        for (int num : nums) {
            if (num < 0)
                negative.add(num);
            else
                positive.add(num);
        }
        int x = 0;
        for (int i = 0; i < positive.size(); i++) {
            nums[x++] = positive.get(i);
            nums[x++] = negative.get(i);
        }
        return nums;
    }
}