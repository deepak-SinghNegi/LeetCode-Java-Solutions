class Solution {
    public int kthLargestValue(int[][] matrix, int k) {
        int m = matrix.length;
        int n = matrix[0].length;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
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
                if(pq.size() < k ){
                    pq.offer(matrix[i][j]);
                }
                else if(matrix[i][j] > pq.peek() ){
                    pq.poll();
                    pq.offer(matrix[i][j]);
                }

            }
        }
        return  pq.peek();
    }
}