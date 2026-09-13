class Solution {
    public int islandPerimeter(int[][] grid) {
        int rd[] = { -1, 1, 0, 0 };
        int cd[] = { 0, 0, -1, 1 };
        int fence = 0;
        int n = grid.length;
        int m = grid[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    for (int k = 0; k < 4; k++) {
                        int r = rd[k] + i;
                        int c = cd[k] + j;
                        if (r < 0 || r >= n || c < 0 || c >= m)
                            fence++;
                        if (r >= 0 && r < n && c >= 0 && c < m) {
                            if (grid[r][c] == 0)
                                fence++;
                        }

                    }
                }
            }
        }
        return fence;
    }
}