class Solution {
    public int[][] sortTheStudents(int[][] score, int k) {
        int m = score.length;
        int n = score[0].length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[k] - a[k]);
        for (int[] arr : score) {
            pq.add(arr);
        }
        int ans[][] = new int[m][n];
        for (int i = 0; i < m; i++) {
            int[] temp = pq.poll();
            for (int j = 0; j < n; j++) {
                ans[i][j] = temp[j];
            }
        }
        return ans;
    }
}