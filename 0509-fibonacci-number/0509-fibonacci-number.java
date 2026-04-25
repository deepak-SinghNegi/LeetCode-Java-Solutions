class Solution {
    public int fib(int n) {
        int[] memo = new int[n + 1];
        Arrays.fill(memo, -1);
      
        return helper(memo, n);
    }

    private int helper(int[] memo, int n) {
        if (n < 2)
            memo[n] = n;
        if (memo[n] != -1)
            return memo[n];

        memo[n] =  helper(memo, n - 1) + helper(memo, n - 2);
        return memo[n];
    }
}