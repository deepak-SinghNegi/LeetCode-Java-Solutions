class Solution {
    public int maxOperations(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int c = 0;
        for (int i = 0; i < nums.length; i++) {
            int val = k - nums[i];
            if (map.containsKey(val) && map.get(val) > 0) {
                c++;
                map.put(val, map.get(val) - 1);
            } else
                map.put(nums[i] , map.getOrDefault(nums[i], 0) + 1);
        }
        return c;
    }
}