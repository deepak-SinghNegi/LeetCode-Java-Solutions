class Solution {
    public void setZeroes(int[][] matrix) {
        int[] rowPtr = new int[matrix.length];
        Arrays.fill(rowPtr, -1);
        int[] colPtr = new int[matrix[0].length];
        Arrays.fill(colPtr, -1);

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    rowPtr[i] = 0;
                    colPtr[j] = 0;

                }

            }
        }
        for (int i = 0; i < colPtr.length; i++) {
            if (colPtr[i] == 0) {
                for (int j = 0; j < matrix.length; j++) {
                    matrix[j][i] = 0;
                }
            }
        }
        for (int i = 0; i < rowPtr.length; i++) {
            if (rowPtr[i] == 0) {
                for (int j = 0; j < matrix[0].length; j++) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}