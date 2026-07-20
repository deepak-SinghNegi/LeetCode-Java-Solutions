class Solution {
    public int removeDuplicates(int[] nums) {
        int k = 1;
        int freq = 1;
        int val = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != val) {

                val = nums[i];
                nums[k++] = val;
                freq = 1;

            } else {
                if (freq < 2) {
                    if (nums[k] < nums[i]) {
                        nums[k] = val;
                    }
                    k++;
                    freq++;
                }

            }
        }
        return k;
    }
}