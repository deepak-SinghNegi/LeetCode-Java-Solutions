class Solution {
    public int countPartitions(int[] nums) {
        int n = nums.length;
        int[] prifix = new int[n];
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (i == 0)
                prifix[i] = nums[i];
            else
                prifix[i] = prifix[i - 1] + nums[i];
        }
        
        int ref = prifix[n - 1];
        
           
        for (int i = 0; i < n-1; i++) {
            int val = prifix[i];
            int diff = Math.abs((ref - val) - val);
            if (diff % 2 == 0)
                count++;
        }
        return count;
    }
}