class Solution {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        if (r * c != mat.length * mat[0].length)
            return mat;
        int[][] ans = new int[r][c];
        int[] copy = new int[mat.length * mat[0].length];
        int x = 0;
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                copy[x++] = mat[i][j];
            }
        }
        x = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                ans[i][j] = copy[x++];
            }
        }
        return ans;
    }
}