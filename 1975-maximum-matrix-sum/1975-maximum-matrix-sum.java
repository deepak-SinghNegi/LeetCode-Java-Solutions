class Solution {
    public long maxMatrixSum(int[][] matrix) {
        long maxMatrixSum = 0;
        // long maxNagetiveSum = 0;
        long minAbsVal = Integer.MAX_VALUE;
        int count = 0;

        for (int i = 0; i < matrix.length; i++) {
            long sum = 0;
            for (int j = 0; j < matrix[i].length; j++) {
                int elm = Math.abs(matrix[i][j]);
                if (matrix[i][j] <= 0) {
                    count++;
                    
                    // maxNagetiveSum+=Math.abs(elm);
                }
                minAbsVal = Math.min(elm, minAbsVal);

                sum += elm;
            }
            maxMatrixSum += sum;
        }

        if (count % 2 == 0) {
            return maxMatrixSum;
        }

        else {
            maxMatrixSum -= (2 * minAbsVal);
            return maxMatrixSum;
        }
    }
}