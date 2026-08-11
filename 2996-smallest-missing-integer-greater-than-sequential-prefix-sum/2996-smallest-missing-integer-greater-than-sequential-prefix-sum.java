class Solution {
    public int missingInteger(int[] nums) {
        int ans = nums[0];
        int l = 0;
        Set<Integer> set = new HashSet<>();
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1] + 1) {
                l = i - 1;
                break;
            }
            ans += nums[i];
        }

        while (l < nums.length) {

            set.add(nums[l++]);
        }
        while (set.contains(ans)) {
            ans++;
        }
        return ans;
    }
}