class Solution {
    public long[] distance(int[] nums) {
        int n = nums.length;
        HashMap<Integer, Integer> freq = new HashMap<>();
        HashMap<Integer, Long> sum = new HashMap<>();
        long[] prifix = new long[n];
        for (int i = 0; i < n; i++) {
            int x = freq.getOrDefault(nums[i], 0);
            long y = sum.getOrDefault(nums[i], 0L);
            prifix[i] = (long) x * i - y;
            freq.put(nums[i], x + 1);
            sum.put(nums[i], y + i);

        }
        freq.clear();
        sum.clear();
        for (int i = n - 1; i >= 0; i--) {
            int x = freq.getOrDefault(nums[i], 0);
            long y = sum.getOrDefault(nums[i], 0L);
            prifix[i] += (y - (long) i * x);
            freq.put(nums[i], x + 1);
            sum.put(nums[i], y + i);
        }
        return prifix;
    }
}