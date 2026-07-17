class Solution {
    public int longestConsecutive(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], nums[i] + 1);
        }
        int maxCount = 0;
        for (Integer num : map.keySet()) {

            if (!map.containsKey(num - 1)) {
                int currCount = 1;
                int check = map.get(num);
                while (map.containsKey(check)) {
                    currCount++;
                    check++;
                }

                maxCount = Math.max(currCount, maxCount);
            }

        }

        return maxCount;
    }
}