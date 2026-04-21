class Solution {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        int[] prifix = new int[n];
        prifix[0] = nums[0];
        for (int i = 1; i < n; i++) {
            prifix[i] = nums[i] + prifix[i - 1];
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = -10001;
        int c = 0;

        int i = 0;
        while (i < n) {

            if (sum == k) {
                c++;

            }
            int val = sum - k;
            if (map.containsKey(val))
                c = map.get(val);
            map.put(val, map.getOrDefault(val, 0) + 1);
            i++;

        }
        return c;
    }
}