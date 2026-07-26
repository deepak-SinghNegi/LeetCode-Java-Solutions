class Solution {
    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        boolean visited[][] = new boolean[m][n];
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                char ch = board[i][j];
                if (ch == 'X')
                    visited[i][j] = true;
                else {
                    if (i != 0 && j != 0 && i != m - 1 && j != n - 1){
                        board[i][j] = 'X';
                        
                    }
                        
                    else
                        q.add(new int[] { i, j });
                }
            }
        }
        int[] hd = { 0, 0, -1, 1 };
        int[] vd = { -1, 1, 0, 0 };
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int cr = curr[0];
            int cc = curr[1];
            visited[cr][cc] = true;
            for (int x = 0; x < 4; x++) {
                int nr = hd[x] + cr;
                int nc = vd[x] + cc;
                if (nr >= 0 && nr < m && nc >= 0 && nc < n) {
                    if (!visited[nr][nc]) {
                        board[nr][nc] = 'O';
                        q.add(new int[] { nr, nc });
                    }
                }
            }

        }
    }
}