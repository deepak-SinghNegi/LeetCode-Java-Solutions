class Solution {
    int m = 0;
    int n = 0;

    public int[][] updateMatrix(int[][] mat) {
        m = mat.length;
        n = mat[0].length;
        Queue<int[]> q = new LinkedList<>();
        boolean visited[][] = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    visited[i][j] = true;
                    q.offer(new int[] { i, j, 0 });
                }
            }
        }
        int[] dr = { -1, 1, 0, 0 };
        int[] dc = { 0, 0, -1, 1 };
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                int curr[] = q.poll();
                int count = curr[2];

                for (int i = 0; i < 4; i++) {
                    int r = curr[0] + dr[i];
                    int c = curr[1] + dc[i];
                    if (r >= 0 && r < m && c >= 0 && c < n && !visited[r][c]) {
                        visited[r][c] = true;
                        
                        q.add(new int[] { r, c, count +1});
                    }
                }
                mat[curr[0]][curr[1]] = count;
            }
        }
        return mat;
    }
}