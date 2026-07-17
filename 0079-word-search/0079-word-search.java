class Solution {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == word.charAt(0)) {
                   
                    visited[i][j] = true;
                    if (dfs(board, visited, word,  i, j, 1))
                        return true;
                    visited[i][j] = false;
                }
            }
        }
        return false;
    }

    boolean dfs(char[][] board, boolean visited[][], String word, int i, int j, int wi) {
        if (wi == word.length())
            return true;

        int[] dr = { 1, -1, 0, 0 };
        int[] dc = { 0, 0, 1, -1 };
        boolean flag = false;
        for (int indx = 0; indx < 4; indx++) {

            int r = dr[indx] + i;
            int c = dc[indx] + j;
            if (r >= 0 && c >= 0 && r < board.length && c < board[0].length) {
                if (board[r][c] == word.charAt(wi) && !visited[r][c]) {
                   
                    visited[r][c] = true;
                    flag |= dfs(board, visited, word, r, c, wi + 1);
                }

            }
        }
        visited[i][j] = false; 
      
        return flag;
    }
}