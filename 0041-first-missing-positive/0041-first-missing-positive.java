class Solution {
    public int firstMissingPositive(int[] nums) {
        if(nums.length == 1) return nums[0] != 1 ? 1 : 2;
        int l = 0, r = nums.length - 1;
        HashMap<Integer, Integer> map = new HashMap<>();
        while (l <= r) {
            if (nums[l] > 0)
                map.put(nums[l], map.getOrDefault(nums[l], 0) + 1);
            if (nums[r] > 0)
                map.put(nums[r], map.getOrDefault(nums[r], 0) + 1);
                l++;
                r--;
        }
        int c = 1;
        while (map.containsKey(c))
            c++;
        return c;
    }

}