class Solution {
    public long[] distance(int[] nums) {
        int n = nums.length;
        HashMap<Integer, Integer> freq = new HashMap<>();
        HashMap<Integer, Long> sum = new HashMap<>();
        long[] prifix = new long[n];
        for (int i = 0; i < n; i++) {
            freq.put(nums[i], freq.getOrDefault(nums[i], 1) + 1);
            int x = freq.get(nums[i]);
            sum.put(nums[i], sum.getOrDefault(nums[i], 0L) + i);
            long y = sum.get(nums[i]);
            prifix[i] = (long)x * i - y;

        }
        freq.clear();
        sum.clear();
        for (int i = n - 1; i >= 0; i--) {
            freq.put(nums[i], freq.getOrDefault(nums[i], 1) + 1);
            int x = freq.get(nums[i]);
            sum.put(nums[i], sum.getOrDefault(nums[i], 0L) + i);
            long y = sum.get(nums[i]);
            prifix[i] += (y - (long)i * x);
        }
        return prifix;
    }
}