class Solution {
    public int kthLargestValue(int[][] matrix, int k) {
        int m = matrix.length;
        int n = matrix[0].length;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for (int i = 0; i < m; i++) {

            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    pq.add(matrix[i][j]);
                    continue;
                } else if (i == 0) {
                    matrix[i][j] ^= matrix[i][j - 1];
                } else if (j == 0) {
                    matrix[i][j] ^= matrix[i - 1][j];
                } else {
                    matrix[i][j] = matrix[i - 1][j]
                            ^ matrix[i][j - 1]
                            ^ matrix[i - 1][j - 1]
                            ^ matrix[i][j];
                }
                pq.add(matrix[i][j]);

            }
        }

        int ans = 0;
        while (k > 0) {
            ans = pq.poll();
            k--;
        }
        return  ans;
    }
}