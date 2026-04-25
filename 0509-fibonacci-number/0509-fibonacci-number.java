class Solution {
    public int fib(int n) {
        int[] DP = new int[n + 1];
        Arrays.fill(DP, -1);
        return helper(DP, n);
    }

    private int helper(int[] DP, int n) {
        if (n < 2)
            DP[n] = n;
        if (DP[n] != -1)
            return DP[n];

        return helper(DP, n - 1) + helper(DP, n - 2);
    }
}