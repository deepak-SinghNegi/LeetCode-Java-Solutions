class Solution {
    public int fib(int n) {
        int[] memo = new int[n + 1];
        Arrays.fill(memo, -1);
        memo[0] = 0;
        memo[1] = 1;
      
        return helper(memo, n);
    }

    private int helper(int[] memo, int n) {
        
        if (memo[n] != -1)
            return memo[n];

        return helper(memo, n - 1) + helper(memo, n - 2);
    }
}