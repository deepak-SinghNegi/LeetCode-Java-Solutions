class Solution {
    public int maxProductPath(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        long[][] max = new long[m][n];
        long[][] min = new long[m][n];
        long mod= 1000000007; 
        max[0][0] = min[0][0] = grid[0][0];
        for (int i = 1; i < m; i++) {
            max[i][0] = max[i - 1][0] * grid[i][0];
            min[i][0] = min[i - 1][0] * grid[i][0];
        }
        for (int i = 1; i < n; i++) {
            max[0][i] = max[0][i - 1] * grid[0][i];
            min[0][i] = min[0][i - 1] * grid[0][i];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                int val = grid[i][j];

                long max1 = Math.max(max[i - 1][j] * val, min[i - 1][j] * val);
                long min1 = Math.min(max[i - 1][j] * val, min[i - 1][j] * val);
                long max2 = Math.max(max[i][j - 1] * val, min[i][j - 1] * val);
                long min2 = Math.min(max[i][j - 1] * val, min[i][j - 1] * val);
                max[i][j] = Math.max(max1, max2);
                min[i][j] = Math.min(min1, min2);
            }
        }
        long ans = max[m - 1][n - 1];
        return ans < 0 ? -1 : (int) (ans % mod);
    }
}