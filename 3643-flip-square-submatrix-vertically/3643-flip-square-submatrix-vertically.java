class Solution {
    public int[][] reverseSubmatrix(int[][] grid, int x, int y, int k) {

        for (int i = y; i < y + k; i++) {
            int s = x;
            int e = s + k - 1;
            while (s < e) {
                int temp = grid[s][i];
                grid[s][i] = grid[e][i];
                grid[e][i] = temp;
                e--;
                s++;
            }
        }
        return grid;
    }
}