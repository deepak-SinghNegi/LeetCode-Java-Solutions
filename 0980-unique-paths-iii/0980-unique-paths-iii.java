class Solution {
    int ways = 0;
    int empty = 0;
    public int uniquePathsIII(int[][] grid) {
        
        int sr = 0;
        int sc = 0;
        for (int i = 0; i< grid.length;i++){
            for(int j  = 0; j < grid[0].length;j++){
                if(grid[i][j] == 1) {
                    sr = i;
                    sc = j;
                }
                else if(grid[i][j] == 0)empty++;
            }
        }
        dfs(sr, sc , grid);
        return ways;
    }
   private void dfs(int r, int c, int[][] grid) {

    if (r < 0 || c < 0 || r >= grid.length || c >= grid[0].length)
        return;

    if (grid[r][c] == -1)
        return;

    if (grid[r][c] == 2) {

        if (empty == -1)
            ways++;

        return;
    }

    empty--;
    grid[r][c] = -1;

    int[] dr = { -1, 1, 0, 0 };
    int[] dc = { 0, 0, -1, 1 };

    for (int i = 0; i < 4; i++) {
        dfs(r + dr[i], c + dc[i], grid);
    }

    grid[r][c] = 0;
    empty++;
}
}