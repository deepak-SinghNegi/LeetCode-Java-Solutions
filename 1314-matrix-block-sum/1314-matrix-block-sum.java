class Solution {
    public int[][] matrixPrifixSum(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] ans = new int[m][n];
        ans[0][0] = matrix[0][0];
        for (int i = 1; i < m; i++) {
            ans[i][0] = ans[i - 1][0] + matrix[i][0];
        }
        for (int i = 1; i < n; i++) {
            ans[0][i] = ans[0][i - 1] + matrix[0][i];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                ans[i][j] = ans[i][j - 1] + ans[i - 1][j] + matrix[i][j] - ans[i - 1][j - 1];
            }
        }
        return ans;
    }

    public int[][] matrixBlockSum(int[][] mat, int k) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] prifix = matrixPrifixSum(mat);
        int[][] ans = new int[m][n];

        int rLow = 0;
        int rHigh = 0;
        int cLow = 0;
        int cHigh = 0;
        for (int i = 0; i < m; i++) {
            rLow = Math.max(0, i - k);
            rHigh = Math.min(m - 1, i + k);
            for (int j = 0; j < n; j++) {
                cLow = Math.max(0, j - k);
                cHigh = Math.min(n - 1, j + k);
                if (rLow <= 0 && cLow <= 0)
                    ans[i][j] = prifix[rHigh][cHigh];
                else {
                    if (cLow > 0 && rLow <= 0)
                        ans[i][j] = prifix[rHigh][cHigh] - prifix[rHigh][cLow - 1];
                    else if (rLow > 0 && cLow <= 0)
                        ans[i][j] = prifix[rHigh][cHigh] - prifix[rLow - 1][cHigh];
                    else
                        ans[i][j] = prifix[rHigh][cHigh]
                                - (prifix[rHigh][cLow - 1] + prifix[rLow - 1][cHigh] - prifix[rLow - 1][cLow - 1]);

                }
            }
        }
        return ans;
    }
}